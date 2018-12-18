package com.shorelinesolution.xml.jaxb.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType (name="", propOrder = {
		"listOfData"
})
public class RuleType {
	@XmlAttribute(name = "name", required=true)
	protected String name;
	
	@XmlElement(name = "data")
	protected List<DataType> listOfData;

	public String getName() {
		return name;
	}

	public List<DataType> getListOfData() {
		return listOfData;
	}
	
	public RuleType(String aName, List<DataType> listofDataType){
		name = aName;
		listOfData = listofDataType;
		
	}

	public RuleType() {

	}

}
