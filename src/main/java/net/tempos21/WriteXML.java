package net.tempos21;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;



import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class WriteXML {
	private DocumentBuilderFactory docFactory = null;
	private DocumentBuilder docBuilder = null;
	private Document doc;

	public Document getDoc() {
		return doc;
	}
	public WriteXML() {
		super();
		  try {
				docFactory = DocumentBuilderFactory.newInstance();
				docBuilder = docFactory.newDocumentBuilder();
				doc = docBuilder.newDocument();
		  } catch (ParserConfigurationException pce) {
				pce.printStackTrace();
		  }
	}
	public String displyXML(){
		try {
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			StreamResult result = new StreamResult(new java.io.StringWriter());
			DOMSource source1 = new DOMSource(doc);
			transformer.transform(source1, result);
			return result.getWriter().toString();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		}
		return null;
	}

	public void writeXML(String path) {
		try {
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new java.io.File(path));
			transformer.transform(source, result);
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		}
	}
	public void	createTextNode(Element element,String elementName,String textNode){
		Element e = doc.createElement(elementName);
		e.appendChild(doc.createTextNode(textNode));
		element.appendChild(e);
	}
	
	
	public void createCDATASection(Element element,String elementName,String sectionName){
		Element e = doc.createElement(elementName);
		e.appendChild(doc.createCDATASection(sectionName) );
		element.appendChild(e);	
	
	}
	
	public Element createElement(Element element, String elementName){
		Element e = doc.createElement(elementName);
		if(element == null){
			doc.appendChild(e);
		}else{
			element.appendChild(e);	
		}
		return e;
	}
	public Element createElement(Element element, String elementName,String attrName,String valueAttr){
		Element e = doc.createElement(elementName);
		Attr attr = doc.createAttribute(attrName);
		attr.setValue(valueAttr);
		e.setAttributeNode(attr);
		if(element == null){
			doc.appendChild(e);
		}else{
			element.appendChild(e);	
		}
		return e;
	}
	public Element createElement(Element element, String elementName,String attrName1,String valueAttr1,String attrName2,String valueAttr2){
		Element e = doc.createElement(elementName);
		Attr attr1 = doc.createAttribute(attrName1);
		attr1.setValue(valueAttr1);
		e.setAttributeNode(attr1);
		Attr attr2 = doc.createAttribute(attrName2);
		attr2.setValue(valueAttr2);
		e.setAttributeNode(attr2);
		if(element == null){
			doc.appendChild(e);
		}else{
			element.appendChild(e);	
		}
		return e;
	}

}
