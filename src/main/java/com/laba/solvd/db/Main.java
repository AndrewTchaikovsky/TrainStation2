package com.laba.solvd.db;

import com.laba.solvd.db.parsers.JacksonParser;
import com.laba.solvd.db.parsers.JaxbParser;
import com.laba.solvd.db.parsers.StaxParser;
import com.laba.solvd.db.parsers.XmlValidatorUsingStax;
import org.apache.log4j.Logger;

import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;


public class Main {
    public static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) throws XMLStreamException, FileNotFoundException {
        String xmlFilePath = "src/main/resources/TrainStation.xml";
        String xsdFilePath = "src/main/resources/TrainStation.xsd";
        String jsonFilePath = "src/main/resources/TrainStation.json";

        XmlValidatorUsingStax.validateXML(xmlFilePath, xsdFilePath);

        StaxParser staxParser = new StaxParser();
        staxParser.parse(xmlFilePath);

        JaxbParser jaxbParser = new JaxbParser();
        jaxbParser.parse(xmlFilePath);

        JacksonParser jacksonParser = new JacksonParser();
        jacksonParser.parse(jsonFilePath);
    }
}