package org.example;

import org.example.controller.FactParser;
import org.example.controller.RuleParser;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        System.out.println("Welcome to Expert System!");
        System.out.println("------------------------------");

        FactParser factParser = new FactParser();
        factParser.loadXmlDocument("Facts.xml");
        RuleParser ruleParser = new RuleParser();
        ruleParser.loadXmlDocument("Rules.xml");

        ESProvider esProvider = new ESProvider(factParser, ruleParser);
        esProvider.run();
    }
}
