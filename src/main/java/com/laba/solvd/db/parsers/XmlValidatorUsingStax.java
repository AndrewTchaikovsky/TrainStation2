package com.laba.solvd.db.parsers;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stax.StAXSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class XmlValidatorUsingStax {
    public static Logger logger = Logger.getLogger(XmlValidatorUsingStax.class);
    public static void validateXML(String xmlFilePath, String xsdFilePath) {
        try {
            XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
            FileInputStream xmlInputStream = new FileInputStream(xmlFilePath);
            XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(xmlInputStream);

            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = schemaFactory.newSchema(new StreamSource(Files.newInputStream(Paths.get(xsdFilePath))));
            Validator validator = schema.newValidator();
            validator.validate(new StAXSource(xmlStreamReader));

            xmlStreamReader.close();
            xmlInputStream.close();

            logger.info("XML is valid against the XSD schema.");
        } catch (IOException e) {
            logger.info("Error reading XML or XSD file: " + e.getMessage());
        } catch (XMLStreamException | SAXException e) {
            throw new RuntimeException(e);
        }
    }
    }

