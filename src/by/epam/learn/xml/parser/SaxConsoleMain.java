package by.epam.learn.xml.parser;

import by.epam.learn.xml.handler.ConsoleStudentHandler;
import by.epam.learn.xml.handler.StudentErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class SaxConsoleMain {
    public static void main(String[] args) {
        try {
// SAX parser creating & configuring
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            XMLReader reader = parser.getXMLReader();
            reader.setContentHandler(new ConsoleStudentHandler());
            reader.setErrorHandler(new StudentErrorHandler());
            reader.parse("data_xml/students.xml");
        } catch (SAXException | IOException | ParserConfigurationException e) {
            e.printStackTrace();
        }
    }
}
