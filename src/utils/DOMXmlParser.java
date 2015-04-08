package utils;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class DOMXmlParser {

    public String m_fileToParse = "";

    public DOMXmlParser(String fileToParse) {
        m_fileToParse = fileToParse;
    }

    public void parse() {
        System.out.println("\nStart parsing xml file with airplanes");
        try {
            File xmlFile = new File(m_fileToParse);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            doc.getDocumentElement().normalize();


            System.out.println("\nParsing planes in company :" + doc.getDocumentElement().getAttribute("name"));

            NodeList nList = doc.getElementsByTagName("plane"); // get plane with all characteristics in aviacompany

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    System.out.println("Airplane id         : " + eElement.getAttribute("id"));
                    System.out.println("Airplane name       : " + eElement.getElementsByTagName("name").item(0).getTextContent());
                    System.out.println("Airplane capacity   : " + eElement.getElementsByTagName("capacity").item(0).getTextContent());
                    System.out.println("Airplane range      : " + eElement.getElementsByTagName("range").item(0).getTextContent());
                    System.out.println("Airplane volume     : " + eElement.getElementsByTagName("volume").item(0).getTextContent());
                    System.out.println("Airplane speed      : " + eElement.getElementsByTagName("speed").item(0).getTextContent());
                }
            }
        } catch (Exception e) {
            System.err.println("Failed to parse the filefile" + e.getMessage());
        }

    }
}
