package com.laba.solvd.db.parsers;

import com.laba.solvd.db.model.TrainStation;

import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;

public interface Parser {
    TrainStation parse(String string) throws FileNotFoundException, XMLStreamException;
}
