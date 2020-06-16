package org.example.controller;

import org.example.model.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.Arrays;
import java.util.List;

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

            for (int elementIndex = 0; elementIndex < elementList.getLength(); elementIndex++){
                Node ruleNode = elementList.item(elementIndex);

                if (ruleNode.getNodeType() != Node.ELEMENT_NODE) {
                    continue;
                }
                Element rule = (Element) ruleNode;
                String ruleId = rule.getAttribute("id");

                Element questionElement = (Element) rule.getElementsByTagName("Question").item(0);
                String questionContent = questionElement.getTextContent();
                //System.out.println("Category: " + ruleId + " | " + question);

                Element answerElement = (Element) rule.getElementsByTagName("Answer").item(0);
                NodeList selectionList = answerElement.getElementsByTagName("Selection");
                Answer answer = getAnswer(selectionList);

                Question question = new Question(ruleId, questionContent, answer);
                ruleRepository.addQuestion(question);
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private Answer getAnswer(NodeList selectionList){
        Answer answer = new Answer();
        for (int selectionIndex = 0; selectionIndex < selectionList.getLength(); selectionIndex++){
            Node selectionNode = selectionList.item(selectionIndex);
            if (selectionNode.getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }

            Element selectionElement = (Element) selectionNode;
            String selectionValue = selectionElement.getAttribute("value");
            boolean selectionType = selectionValue.equals("true");
            //System.out.println("boolean value: " + selectionValue);

            NodeList valueNodeList = selectionElement.getChildNodes();
            for (int valueIndex = 0; valueIndex < valueNodeList.getLength(); valueIndex++){
                Node valueNode = valueNodeList.item(valueIndex);
                if (valueNode.getNodeType() != Node.ELEMENT_NODE) {
                    continue;
                }

                if (valueNode.getNodeName().equals("SingleValue")){
                    Element singleValueElement = (Element) valueNode;
                    String singleValue = singleValueElement.getAttribute("value");
                    //System.out.println("answer: " + singleValue);
                    Value value = new SingleValue(singleValue, selectionType);

                    answer.addValue(value);
                }
                else if (valueNode.getNodeName().equals("MultipleValue")){
                    Element multipleValueElement = (Element) valueNode;
                    String multipleValues = multipleValueElement.getAttribute("value");

                    List<String> multipleValuesList = Arrays.asList(multipleValues.split(","));

                    //System.out.println("answer: " + multipleValue);
                    Value value = new MultipleValue(multipleValuesList, selectionType);

                    answer.addValue(value);
                }
            }

        }
        return answer;
    }
}
