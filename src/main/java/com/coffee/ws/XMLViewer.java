package com.coffee.ws;

import java.io.File;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

public class XMLViewer {

	public Document document;

	public static final String XMLVIEWER = "D:\\BENTOI-MASTERFILES\\KNOWLEDGEBASE\\GIT-REPO\\knowledgebase\\XML\\xmlviewer.xml";

	public XMLViewer( Document document) {
		this.document = document;

	}

	public void generateXMLViewer(boolean toGenerateFile) {

		StreamResult streamresult = null;
		try {

			// generate xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer;
			transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "3");

			DOMSource domsource = new DOMSource(document);

			if (toGenerateFile) {
				streamresult = new StreamResult(new File(XMLVIEWER));
			} else {
				//for testing and development
				streamresult = new StreamResult(System.out);
			}

			transformer.transform(domsource, streamresult);
			
			System.out.println("Done generating XML file");

		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
