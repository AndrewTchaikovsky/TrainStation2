package com.laba.solvd.db.parsers;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class StaxParser {
    public void parseXML(String xmlFilePath) {
        try {
            XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
            XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(new FileInputStream(xmlFilePath));

            while (xmlStreamReader.hasNext()) {
                int event = xmlStreamReader.next();

                switch (event) {
                    case XMLStreamConstants.START_ELEMENT:
                        System.out.println("Start Element: " + xmlStreamReader.getLocalName());
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        String text = xmlStreamReader.getText().trim();
                        if (!text.isEmpty()) {
                            System.out.println("Text: " + text);
                        }
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        System.out.println("End Element: " + xmlStreamReader.getLocalName());
                        break;
                }
            }

            xmlStreamReader.close();
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
    }
}

