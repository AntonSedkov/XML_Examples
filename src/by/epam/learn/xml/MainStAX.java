package by.epam.learn.xml;

import by.epam.learn.xml.parser.StudentsStaxBuilder;

public class MainStAX {
    public static void main(String[] args) {
        StudentsStaxBuilder staxBuilder = new StudentsStaxBuilder();
        staxBuilder.buildSetStudents("data_xml/students.xml");
        System.out.println(staxBuilder.getStudents());
    }
}