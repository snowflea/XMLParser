package com.shorelinesolution.xml.jaxb.model;

import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import javax.xml.bind.JAXBElement;

@XmlRegistry
public class ObjectFactory {

	private final static QName _Rules_QNAME = new QName("", "rules");
	
	public ObjectFactory(){	
	}
	
	public RootType createRulesType(){
		return new RootType();
	}
	
	/**
	 * 
	 * create an instance of ({@link RuleType}
	 */
	public RuleType createRuleType(){
	
		return new RuleType();
	}
		
	public DataType createDataType(){
			return new DataType();
	}
	
	public MessageType createMessageType(){
		return new MessageType();
	}
	
	@XmlElementDecl(namespace="", name="rules")
	public JAXBElement<RootType> createRules(RootType value){
		return new JAXBElement<RootType>(_Rules_QNAME, RootType.class, null, value);
	}
}

