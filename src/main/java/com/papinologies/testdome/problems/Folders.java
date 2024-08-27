package com.papinologies.testdome.problems;

import java.util.ArrayList;
import java.util.Collection;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Folders {
    public static Collection<String> folderNames(String xml, char startingLetter) throws Exception {
        Collection<String> result = new ArrayList<>();
        // Parse the XML string
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new org.xml.sax.InputSource(new java.io.StringReader(xml)));

        // Get all elements named "folder"
        NodeList folderList = document.getElementsByTagName("folder");

        for (int i = 0; i < folderList.getLength(); i++) {
            Node folderNode = folderList.item(i);
            if (folderNode.getNodeType() == Node.ELEMENT_NODE) {
                Element folderElement = (Element) folderNode;
                String folderName = folderElement.getAttribute("name");

                // Check if the folder name starts with the given letter
                if (!folderName.isEmpty() && folderName.charAt(0) == startingLetter) {
                    result.add(folderName);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) throws Exception {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                "<folder name=\"c\">" +
                "<folder name=\"program files\">" +
                "<folder name=\"uninstall information\" />" +
                "</folder>" +
                "<folder name=\"users\" />" +
                "</folder>";

        Collection<String> names = folderNames(xml, 'u');
        for (String name : names)
            System.out.println(name);
    }
}
