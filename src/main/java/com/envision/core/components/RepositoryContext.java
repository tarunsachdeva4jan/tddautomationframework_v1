package com.envision.core.components;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class RepositoryContext {

	public static String FetchValueFromOR(String pageName, String elementName, String type)
			throws ParserConfigurationException, SAXException, IOException, Exception {
		File documentFile = new File(
				System.getProperty("user.dir") + "//src//main//resources//OR.xml");

		DocumentBuilderFactory dbFactoryBuilder = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactoryBuilder.newDocumentBuilder();
		Document document = dBuilder.parse(documentFile);

		XPathFactory xpathFactory = XPathFactory.newInstance();
		XPath xpath = xpathFactory.newXPath();
		XPathExpression xExpression = null;

		if (type.equalsIgnoreCase("id")) {
			xExpression = xpath.compile("//Pages//" + pageName + "//" + elementName + "/id/text()"); // Pages//LoginPage//tbx_username/id/text()
		} else if (type.equalsIgnoreCase("xpath")) {
			xExpression = xpath
					.compile("//Pages//" + pageName + "//" + elementName + "/xpath/text()");
		}
		return (String) xExpression.evaluate(document, XPathConstants.STRING);

	}

	public static String FetchIDFromOR(String pageName, String elementName) throws Exception {
		return FetchValueFromOR(pageName, elementName, "id");
	}

	public static String FetchXpathFromOR(String pageName, String elementName) throws Exception {
		return FetchValueFromOR(pageName, elementName, "xpath");
	}

}
