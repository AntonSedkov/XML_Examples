package by.epam.learn.xml;

import by.epam.learn.xml.parser.StudentsSaxBuilder;

public class MainSAX {
    public static void main(String[] args) {
        StudentsSaxBuilder saxBuilder = new StudentsSaxBuilder();
        saxBuilder.buildSetStudents("data_xml/students.xml");
        System.out.println(saxBuilder.getStudents());
    }

}
