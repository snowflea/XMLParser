package com.shorelinesolution.xml.jaxb.model;



import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Message can have one type of field: insert
 * @author tywang
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType (name="", propOrder = {
		"inserts"
})
public class MessageType {
	//message value identify one unique message
	@XmlAttribute(name = "value")
	protected String value;
	
	//list of inserts 
	@XmlElement(name = "insert")
	protected List<String> inserts;

	public String getValue() {
		return value;
	}

	public List<String> getInserts() {
		return inserts;
	}
	
	public MessageType(String aValue, List<String> insertsList){
		value = aValue;
		inserts = insertsList;
	}

	public MessageType() {
		// TODO Auto-generated constructor stub
	}
	
	
}
