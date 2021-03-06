package org.example.controller;

import org.example.model.Fact;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class FactParser extends XMLParser{

    private FactRepository factRepository = new FactRepository();

    public FactRepository getFactRepository() {
        return factRepository;
    }

    @Override
    public void loadXmlDocument(String xmlPath) {
        try {
            File file = new File(xmlPath);
            DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance()
                    .newDocumentBuilder();
            Document document = dBuilder.parse(file);
            document.getDocumentElement().normalize();
            NodeList elementList = document.getElementsByTagName("Fact");

            for (int elementIndex = 0; elementIndex < elementList.getLength(); elementIndex++){
                Node node = elementList.item(elementIndex);

                if (node.getNodeType() != Node.ELEMENT_NODE) {
                    continue;
                }
                Element element = (Element) node;
                String elementId = element.getAttribute("id");

                Element subElement = (Element) element.getElementsByTagName("Description").item(0);
                String elementDescription = subElement.getAttribute("value");

                Fact fact = new Fact(elementId, elementDescription);
                setFactValues(fact, element);
                factRepository.addFact(fact);

            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }



    private void setFactValues(Fact fact, Element element){
        Element valuesNode = (Element) element.getElementsByTagName("Evals").item(0);

        NodeList valuesList = valuesNode.getElementsByTagName("Eval");

        for (int valueIndex = 0; valueIndex < valuesList.getLength(); valueIndex++) {
            Element value = (Element) valuesList.item(valueIndex);
            String id = value.getAttribute("id");
            String worth = value.getTextContent();
            fact.setFactValueByID(id, Boolean.valueOf(worth));
        }
    }
}
