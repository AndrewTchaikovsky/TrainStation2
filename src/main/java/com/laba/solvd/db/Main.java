package com.laba.solvd.db;

import com.laba.solvd.db.model.TrainStation;
import com.laba.solvd.db.parsers.*;
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

        Parser parser = new StaxParser();
        TrainStation trainStation = parser.parse(xmlFilePath);

        parser = new JaxbParser();
        trainStation = parser.parse(xmlFilePath);

        parser = new JacksonParser();
        trainStation = parser.parse(jsonFilePath);
    }
}