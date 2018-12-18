package com.shorelinesolution.xml.jaxb.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType (propOrder = {
		"rule"
})

@XmlRootElement(name="rules")
public class RootType {
	
	@XmlElement (name="rule", required=true)
	protected List<RuleType> rule;
	
	public List<RuleType> getRules(){
		if (rule==null){
			rule=new ArrayList<RuleType>();
		}
		return this.rule;
	}
	
	public RootType(List<RuleType> listOfRuleType){
		rule = listOfRuleType ;
		
	}

	public RootType() {
		// TODO Auto-generated constructor stub
	}

	

}
