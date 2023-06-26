package com.laba.solvd.db.parsers;

import com.laba.solvd.db.model.*;
import org.apache.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class JaxbParser implements Parser {
    public static Logger logger = Logger.getLogger(JaxbParser.class);

    public TrainStation parse(String xmlFilePath) {
        TrainStation trainStation = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(TrainStation.class);

            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            File xmlFile = new File(xmlFilePath);
            trainStation = (TrainStation) unmarshaller.unmarshal(xmlFile);

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

                List<EmployeeShift> employeeShifts = employee.getEmployeeShifts();
                for (EmployeeShift employeeShift : employeeShifts) {
                    logger.info("Employee shift ID:" + employeeShift.getId());
                    logger.info("Employee shift start date" + employeeShift.getStartDate());
                    logger.info("Employee shift end date" + employeeShift.getEndDate());
                }

                List<TrainMaintenance> trainMaintenances = employee.getTrainMaintenances();
                for (TrainMaintenance trainMaintenance : trainMaintenances) {
                    logger.info("Train maintenance ID:" + trainMaintenance.getId());
                    logger.info("Train maintenance date:" + trainMaintenance.getDate());
                    logger.info("Train maintenance type:" + trainMaintenance.getType());
                }

            }

            for (Platform platform : platforms) {
                logger.info("Platform ID:" + platform.getId());
                logger.info("Platform number:" + platform.getNumber());

                PlatformStatus platformStatus = platform.getPlatformStatus();
                logger.info("Platform status ID:" + platformStatus.getId());
                logger.info("Platform status:" + platformStatus.getStatus());
            }

        } catch (JAXBException e) {
            logger.error("Error occurred during XML parsing", e);
        }
        return trainStation;
    }
}
