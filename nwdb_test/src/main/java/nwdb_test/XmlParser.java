package nwdb_test;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


// Based on http://viralpatel.net/blogs/java-xml-xpath-tutorial-parse-xml/
public class XmlParser {
	private XPath xPath;
	private Document xmlDocument;
	
	// Construct XPath object xPath
	//  from InputStream in
	XmlParser(InputStream in) {
		xPath =  XPathFactory.newInstance().newXPath();
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = builderFactory.newDocumentBuilder();
			xmlDocument = builder.parse(in);
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
	}

	public String nodeContent(String xExpression) {
	// Return results of query xExpression on xmlDocument 
		String nodeContent = "";
		try {
			nodeContent = xPath.compile(xExpression).evaluate(xmlDocument);
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nodeContent;		
	}
	
	public NodeList nodeList(String xExpression) {
		NodeList nl = null;
		try {
			nl = (NodeList) xPath.compile(xExpression).evaluate(xmlDocument, XPathConstants.NODESET);
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nl;
	}
}
