package org.example;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class RuleParser extends XMLParser{

    private RuleRepository ruleRepository = new RuleRepository();


    public RuleRepository getRuleRepository(){
        return ruleRepository;
    }

    @Override
    public void loadXmlDocument(String xmlPath) {
        try {
            File file = new File(xmlPath);
            DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance()
                    .newDocumentBuilder();
            Document document = dBuilder.parse(file);
            document.getDocumentElement().normalize();
            NodeList elementList = document.getElementsByTagName("Rule");
            for (int elementIndex = 0; elementIndex < elementList.getLength(); elementIndex++) {
                Node node = elementList.item(elementIndex);

                if (node.getNodeType() != Node.ELEMENT_NODE) {
                    continue;
                }
                Element element = (Element) node;
                String elementID = element.getAttribute("id");

                Element subelement = (Element) element.getElementsByTagName("Question").item(0);
                String questionValue = subelement.getTextContent();

                //Answer answer = new Answer();
                //Question question = new Question(elementID, questionValue, answer);
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}
