package com.shorelinesolution.xml.jaxb.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType (name="", propOrder = {
		"descEn",
		"descFr"
})
public class DescriptonType {
	@XmlElement(name = "desc-en", required=true)
	protected String descEn;
	
	@XmlElement(name = "desc-fr", required=true)
	protected String descFr;
	
	public String getEnglishDescription(){
		if (descEn == null){
			descEn = new String("");
		}
		return descEn;
	}
	
	public String getFrenchDescription(){
		if (descFr == null){
			descFr = new String("");
		}
		return descFr;
	}
	
	public DescriptonType(String englishDesc, String frenchDesc){
		descEn = englishDesc;
		descFr = frenchDesc;
		
	}
	
	public DescriptonType(){

		
	}
}
