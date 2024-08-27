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

    /**
     * 
     * Explanation of the Code:
     * XML Parsing:
     * 
     * DocumentBuilderFactory and DocumentBuilder are used to parse the XML string
     * into a Document object.
     * Document represents the entire XML structure.
     * NodeList and Traversing:
     * 
     * getElementsByTagName("folder") retrieves all <folder> elements from the XML.
     * The method iterates through each Node in the NodeList.
     * Check Folder Name:
     * 
     * For each Element node, it retrieves the name attribute.
     * It checks if the folder name starts with the given startingLetter.
     * Collecting Results:
     * 
     * If the name matches the criteria, it is added to the result collection.
     * Output:
     * 
     * The main method demonstrates the functionality by printing folder names that
     * start with 'u'.
     * 
     * @param xml
     * @param startingLetter
     * @return
     * @throws Exception
     */
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
