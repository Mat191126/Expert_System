package org.example;

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

        ESProwider esProwider = new ESProwider(factParser, ruleParser);
        esProwider.displayFacts();
    }
}
