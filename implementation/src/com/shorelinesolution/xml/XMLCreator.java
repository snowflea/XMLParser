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
import com.shorelinesolution.xml.jaxb.model.DescriptonType;
import com.shorelinesolution.xml.jaxb.model.MessageType;
import com.shorelinesolution.xml.jaxb.model.RootType;
import com.shorelinesolution.xml.jaxb.model.RuleType;

public class XMLCreator {
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
	
	public XMLCreator(){
		
		DescriptonType myDesc = new DescriptonType("My English desription", "My French description");
		
		List<String> insertsGr1 = new  ArrayList<String>();
		insertsGr1.add("Insert A1");
		insertsGr1.add("Insert A2");
		MessageType message = new MessageType("messageType1", insertsGr1);
		
		List<String> insertsGr2 = new  ArrayList<String>();
		insertsGr2.add("Insert B1");
		insertsGr2.add("Insert B1");
		MessageType message2 = new MessageType("messageType2", insertsGr2);
		
		List<MessageType> listOfMessages = new ArrayList<MessageType>();
		listOfMessages.add(message);
		listOfMessages.add(message2);
		
		DataType myData = new DataType("YueData1", listOfMessages, myDesc );
		
		List<DataType> listofDataType = new ArrayList<DataType>();
		listofDataType.add(myData);
		
		RuleType ruleType = new RuleType("YueRule1", listofDataType);
		
		List<RuleType> listOfRuleType = new ArrayList<RuleType>();
		listOfRuleType.add(ruleType);
		
		RootType roottype=  new RootType(listOfRuleType);
		createXML(roottype);
	}
	
	
	
	private void createXML(RootType rootType){
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance("com.shorelinesolution.xml.jaxb.model");
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); // To format XML
            
            //Print XML String to Console
            marshaller.marshal(rootType, System.out);
		}catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
