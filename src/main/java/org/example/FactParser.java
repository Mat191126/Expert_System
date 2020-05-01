package org.example;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class FactParser extends XMLParser{

    private FactRepository factRepository;

    FactParser(){
        this.factRepository = new FactRepository();
        createFactRepository();
    }

    public FactRepository getFactRepository() {
        return factRepository;
    }

    private void createFactRepository(){
        loadXmlDocument("Facts.xml");

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

            //System.out.println("ID: " + elementId);

            //System.out.println("DESCRIPTION: " + elementDescription);

            Fact fact = new Fact(elementId, elementDescription);
            setFactValues(fact, element);

            //this.factRepository.addFact(fact);
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
