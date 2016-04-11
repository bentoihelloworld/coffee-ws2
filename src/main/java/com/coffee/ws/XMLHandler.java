package com.coffee.ws;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class XMLHandler {

	private DocumentBuilderFactory documentBuilderFactory;
	private DocumentBuilder documentbuilder;
	private Document document;
	public XMLHandler(String rootDoc) {

	}

	public void createNewDocument() {

		try {
			documentBuilderFactory = DocumentBuilderFactory.newInstance();
			documentbuilder = documentBuilderFactory.newDocumentBuilder();
			document = documentbuilder.newDocument();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Document parseDocument() {

		try {
			documentBuilderFactory = DocumentBuilderFactory.newInstance();
			documentbuilder = documentBuilderFactory.newDocumentBuilder();
			document = documentbuilder.parse(XMLViewer.XMLVIEWER);

		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return document;

	}

}
