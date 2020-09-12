package by.epam.learn.xml;

import by.epam.learn.xml.parser.StudentsDomBuilder;

public class MainDOM {
    public static void main(String[] args) {
        StudentsDomBuilder domBuilder = new StudentsDomBuilder();
        domBuilder.buildSetStudents("data_xml/students.xml");
        System.out.println(domBuilder.getStudents());
    }
}
