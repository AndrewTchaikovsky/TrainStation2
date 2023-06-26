package com.laba.solvd.db;

import com.laba.solvd.db.parsers.JaxbParser;
import com.laba.solvd.db.parsers.StaxParser;
import com.laba.solvd.db.parsers.XmlValidatorUsingStax;
import org.apache.log4j.Logger;


public class Main {
    public static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        String xmlFilePath = "src/main/resources/TrainStation.xml";
        String xsdFilePath = "src/main/resources/TrainStation.xsd";

        XmlValidatorUsingStax.validateXML(xmlFilePath, xsdFilePath);

        StaxParser staxParser = new StaxParser();
        staxParser.parseXML(xmlFilePath);

        JaxbParser jaxbParser = new JaxbParser();
        jaxbParser.parseXML(xmlFilePath);
    }
}