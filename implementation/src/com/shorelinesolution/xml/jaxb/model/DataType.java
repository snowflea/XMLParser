package com.shorelinesolution.xml.jaxb.model;


import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * data has two type of fields(defined as FIELDS): message and description
 *		<data value="00">
 *			<description>
 *				<desc-en>English description</desc-en>
 *				<desc-fr>French description </desc-fr>
 *			</description>
 *		</data>
 *		<data value="01">
 *			<message value="1124"></message>
 *			<message value="1140"></message>
 *		</data>
 * @author tywang
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
//define the order in which the fields are written
@XmlType (name="", propOrder = {
		"messages",
		"description"
})

public class DataType {
	//data value identify one data
	@XmlAttribute(name = "value")
	private String value;
	
	//list of messages 
	@XmlElement(name = "message")
	private List<MessageType> messages;

	//one description assoiated with data
	@XmlElement(name = "description")
	private DescriptonType description;

	public String getValue() {
		return value;
	}

	public List<MessageType> getMessages() {
		return messages;
	}

	public DescriptonType getDescription() {
		return description;
	}
	
	public DataType(String aValue, List<MessageType> listOfMessages, DescriptonType desc ){
		value = aValue;
		messages= listOfMessages;
		description = desc;
	}

	public DataType() {
		// TODO Auto-generated constructor stub
	}

	
	
}
