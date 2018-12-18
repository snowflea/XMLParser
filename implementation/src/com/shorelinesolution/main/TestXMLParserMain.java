package com.shorelinesolution.main;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.shorelinesolution.xml.XMLCreator;
import com.shorelinesolution.xml.XMLRetriever;
import com.shorelinesolution.xml.jaxb.model.MessageType;

/**
 * 
 * @author tywang
 *
 */
public class TestXMLParserMain {
	private final Log LOG = LogFactory.getLog(TestXMLParserMain.class);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		XMLRetriever xmlRetriever = new XMLRetriever();
		try {
			List<MessageType> messages = xmlRetriever.getMessageList("yue", "01");
			for (MessageType message: messages){
				String value = message.getValue();
				System.out.println("value is " + value);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		XMLCreator xmlCreator = new XMLCreator();
	}

}
