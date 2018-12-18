package com.shorelinesolution.xml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xml.sax.InputSource;

import com.shorelinesolution.common.Constants;
import com.shorelinesolution.xml.jaxb.model.DataType;
import com.shorelinesolution.xml.jaxb.model.MessageType;
import com.shorelinesolution.xml.jaxb.model.RootType;
import com.shorelinesolution.xml.jaxb.model.RuleType;




public class XMLRetriever {
//	private XMLRetriever instance = null;
	private HashMap<String, RuleType> cachedRules = new HashMap<String, RuleType>();
	private final Log LOG = LogFactory.getLog(XMLRetriever.class);
	private InputSource inputSource = null;
	
//	private XMLRetriever getInstance(){
//		if (instance == null){
//			instance = new XMLRetriever();
//		}
//		return instance;
//	}
	
	public XMLRetriever(){
		parseAndCacheRulesFile(Constants.MEMBER_XML_FILE);
	}
	
	
	/**
	 * 
	 * @param xmlFile
	 */
	private void parseAndCacheRulesFile(String xmlFile){
		RootType xmlRules = genRulesDataFromXML(xmlFile);
		genCachedRules(xmlRules);
	}
	
	private RootType genRulesDataFromXML(String xmlFile){
		RootType xmlRules = null;
		
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance("com.shorelinesolution.xml.jaxb.model");
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			unmarshaller.setEventHandler(new javax.xml.bind.helpers.DefaultValidationEventHandler());
			if (null == inputSource){
				inputSource = new InputSource(Thread.currentThread().getContextClassLoader().getResourceAsStream(xmlFile));
			}
			JAXBElement<?> element = (JAXBElement<?>) unmarshaller.unmarshal(inputSource);
			xmlRules = (RootType) element.getValue();
			//why following doesn't work?
//			xmlRules =(RootType)unmarshaller.unmarshal(inputSource);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return xmlRules;
	}
	
	private void genCachedRules(RootType xmlRules){
		if (xmlRules == null){
			System.err.println("XML data has not been parsed properly.");
			return;
		}
		for (RuleType r: xmlRules.getRules()){
			cachedRules.put(r.getName(), r);
		}
	}
	
	private RuleType getRule(String name){
		return cachedRules.get(name);
	}
	
	public List<MessageType> getMessageList (String ruleName, String dataId) throws Exception{
		if (null == this.getRule(ruleName)){
			LOG.error("Unable to find rule data: " + ruleName);
			throw new Exception("Unable to find rule data: " + ruleName);
		}
		
		List<DataType> rulesData = this.getRule(ruleName).getListOfData();
		List<MessageType> messages = new ArrayList<MessageType>();
		for (DataType data: rulesData){
			if (data.getValue().equalsIgnoreCase(dataId)){
				messages = data.getMessages();
				break;
			}
		}
		
		return messages;
		
	}
	
}
