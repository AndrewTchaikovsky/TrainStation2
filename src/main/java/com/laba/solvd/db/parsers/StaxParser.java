package com.laba.solvd.db.parsers;

import com.laba.solvd.db.model.*;
import org.apache.log4j.Logger;

import javax.xml.namespace.QName;
import javax.xml.stream.*;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class StaxParser implements Parser {
    public static Logger logger = Logger.getLogger(StaxParser.class);

    public TrainStation parse(String xmlFilePath) throws FileNotFoundException, XMLStreamException {
        TrainStation trainStation = null;

        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        XMLEventReader reader = xmlInputFactory.createXMLEventReader(new FileInputStream(xmlFilePath));

        while (reader.hasNext()) {
            XMLEvent event = reader.nextEvent();

            if (event.isStartElement()) {
                StartElement startElement = event.asStartElement();
                String elementName = startElement.getName().getLocalPart();

                if ("trainstation".equals(elementName)) {
                    trainStation = new TrainStation();
                    Attribute idAttribute = startElement.getAttributeByName(new QName("id"));
                    if (idAttribute != null) {
                        trainStation.setId(Integer.valueOf(idAttribute.getValue()));
                    }
                } else if ("name".equals(elementName)) {
                    event = reader.nextEvent();
                    trainStation.setName(event.asCharacters().getData());
                } else if ("location".equals(elementName)) {
                    event = reader.nextEvent();
                    trainStation.setLocation(event.asCharacters().getData());
                } else if ("employees".equals(elementName)) {
                    trainStation.setEmployees(parseEmployees(reader));
                } else if ("platforms".equals(elementName)) {
                    trainStation.setPlatforms(parsePlatforms(reader));
                }
            }

            if (event.isEndElement()) {
                if ("trainstation".equals(event.asEndElement().getName().getLocalPart())) {
                    break;
                }
            }
        }
        printTrainStationDetails(trainStation);
        return trainStation;
    }

    private List<Employee> parseEmployees(XMLEventReader reader) throws XMLStreamException {
        List<Employee> employees = new ArrayList<>();
        Employee employee = null;

        while (reader.hasNext()) {
            XMLEvent event = reader.nextEvent();

            if (event.isStartElement()) {
                StartElement startElement = event.asStartElement();
                String elementName = startElement.getName().getLocalPart();

                if ("employee".equals(elementName)) {
                    employee = new Employee();
                    Attribute idAttribute = startElement.getAttributeByName(new QName("id"));
                    if (idAttribute != null) {
                        employee.setId(Integer.valueOf(idAttribute.getValue()));
                    }
                } else if ("firstName".equals(elementName)) {
                    event = reader.nextEvent();
                    employee.setFirstName(event.asCharacters().getData());
                } else if ("lastName".equals(elementName)) {
                    event = reader.nextEvent();
                    employee.setLastName(event.asCharacters().getData());
                } else if ("position".equals(elementName)) {
                    event = reader.nextEvent();
                    employee.setPosition(event.asCharacters().getData());
                }
            }

            if (event.isEndElement()) {
                if ("employee".equals(event.asEndElement().getName().getLocalPart())) {
                    employees.add(employee);
                } else if ("employees".equals(event.asEndElement().getName().getLocalPart())) {
                    break;
                }
            }
        }
        return employees;
    }

    private List<Platform> parsePlatforms(XMLEventReader reader) throws XMLStreamException {
        List<Platform> platforms = new ArrayList<>();
        Platform platform = null;

        while (reader.hasNext()) {
            XMLEvent event = reader.nextEvent();

            if (event.isStartElement()) {
                StartElement startElement = event.asStartElement();
                String elementName = startElement.getName().getLocalPart();

                if ("platform".equals(elementName)) {
                    platform = new Platform();
                    Attribute idAttribute = startElement.getAttributeByName(new QName("id"));
                    if (idAttribute != null) {
                        platform.setId(Integer.valueOf(idAttribute.getValue()));
                    }
                } else if ("number".equals(elementName)) {
                    event = reader.nextEvent();
                    platform.setNumber(Integer.valueOf(event.asCharacters().getData()));
                }
            }

            if (event.isEndElement()) {
                if ("platform".equals(event.asEndElement().getName().getLocalPart())) {
                    platforms.add(platform);
                } else if ("employees".equals(event.asEndElement().getName().getLocalPart())) {
                    break;
                }
            }
        }
        return platforms;
    }

    private void printTrainStationDetails(TrainStation trainStation) {
        if (trainStation != null) {
            Integer id = trainStation.getId();
            String name = trainStation.getName();
            String location = trainStation.getLocation();
            List<Employee> employees = trainStation.getEmployees();
            List<Platform> platforms = trainStation.getPlatforms();

            logger.info("Train station ID:" + id);
            logger.info("Train station name:" + name);
            logger.info("Train station location:" + location);

            for (Employee employee : employees) {
                logger.info("Employee ID:" + employee.getId());
                logger.info("Employee first name:" + employee.getFirstName());
                logger.info("Employee last name:" + employee.getLastName());
                logger.info("Employee position:" + employee.getPosition());
            }

            for (Platform platform : platforms) {
                logger.info("Platform ID:" + platform.getId());
                logger.info("Platform number:" + platform.getNumber());

            }
        }
    }
}