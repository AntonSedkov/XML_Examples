package by.epam.learn.xml.parser;

import by.epam.learn.xml.entity.Student;
import by.epam.learn.xml.handler.StudentXmlTag;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import javax.xml.namespace.QName;
import javax.xml.stream.*;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class StudentsStaxBuilder {
    private Set<Student> students;
    private XMLInputFactory inputFactory;

    public StudentsStaxBuilder() {
        inputFactory = XMLInputFactory.newInstance();
        students = new HashSet<Student>();
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void buildSetStudents(String filename) {
        XMLStreamReader reader;
        String name;
        try (FileInputStream inputStream = new FileInputStream(new File(filename))) {
            reader = inputFactory.createXMLStreamReader(inputStream);
// StAX parsing
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    if (name.equals(StudentXmlTag.STUDENT.getValue())) {
                        Student student = buildStudent(reader);
                        students.add(student);
                    }
                }
            }
        } catch (XMLStreamException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Student buildStudent(XMLStreamReader reader)
            throws XMLStreamException {
        Student student = new Student();
        student.setLogin(reader.getAttributeValue(null, StudentXmlTag.LOGIN.getValue()));
// null check
        student.setFaculty(reader.getAttributeValue(null,
                StudentXmlTag.FACULTY.getValue()));
        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (StudentXmlTag.valueOf(name.toUpperCase())) {
                        case NAME -> student.setName(getXMLText(reader));
                        case TELEPHONE -> student.setTelephone(Integer.parseInt(getXMLText(reader)));
                        case ADDRESS -> student.setAddress(getXMLAddress(reader));
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (StudentXmlTag.valueOf(name.toUpperCase()) == StudentXmlTag.STUDENT) {
                        return student;
                    }
            }
        }
        throw new XMLStreamException("Unknown element in tag <student>");
    }

    private Student.Address getXMLAddress(XMLStreamReader reader)
            throws XMLStreamException {
        Student.Address address = new Student().new Address();
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (StudentXmlTag.valueOf(name.toUpperCase())) {
                        case COUNTRY -> address.setCountry(getXMLText(reader));
                        case CITY -> address.setCity(getXMLText(reader));
                        case STREET -> address.setStreet(getXMLText(reader));
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (StudentXmlTag.valueOf(name.toUpperCase()) == StudentXmlTag.ADDRESS) {
                        return address;
                    }
            }
        }
        throw new XMLStreamException("Unknown element in tag <address>");
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }

    public void buildSetStudentsOneMore(String fileName) {
        Student student = null;
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        try {
            XMLEventReader reader = inputFactory.createXMLEventReader(
                    new FileInputStream(fileName));
            while (reader.hasNext()) {
                XMLEvent event = reader.nextEvent();
                if (event.isStartElement()) {
                    StartElement startElement = event.asStartElement();
                    if (startElement.getName().getLocalPart().equals("student")) {
                        student = new Student();
                        Attribute login = startElement.getAttributeByName(new QName("login"));
                        student.setLogin(login.getValue());
                        Attribute faculty = startElement.getAttributeByName(new QName("faculty"));
                        if (faculty != null) {
                            student.setFaculty(faculty.getValue());
                        }
                    } else if (startElement.getName().getLocalPart().equals("telephone")) {
                        event = reader.nextEvent();
                        student.setTelephone(Integer.parseInt(event.asCharacters().getData()));
                    } else if (startElement.getName().getLocalPart().equals("name")) {
                        event = reader.nextEvent();
                        student.setName(event.asCharacters().getData());
                    } else if (event.isStartElement()) {
                        StartElement startElementAddr = event.asStartElement();
                        if (startElement.getName().getLocalPart().equals("country")) {
                            event = reader.nextEvent();
                            student.getAddress().setCountry(event.asCharacters().getData());
                        } else if (startElement.getName().getLocalPart().equals("city")) {
                            event = reader.nextEvent();
                            student.getAddress().setCity(event.asCharacters().getData());
                        } else if (startElement.getName().getLocalPart().equals("street")) {
                            event = reader.nextEvent();
                            student.getAddress().setStreet(event.asCharacters().getData());
                        }
                    }
                }
                if (event.isEndElement()) {
                    EndElement endElement = event.asEndElement();
                    if (endElement.getName().getLocalPart().equals("student")) {
                        students.add(student);
                    }
                }
            }
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
    }

}
