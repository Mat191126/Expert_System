package org.example;

import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public abstract class XMLParser {
    Document document;

    public void loadXmlDocument(String xmlPath){
        try {
            File file = new File(xmlPath);
            DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance()
                    .newDocumentBuilder();
            this.document = dBuilder.parse(file);
            this.document.getDocumentElement().normalize();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
