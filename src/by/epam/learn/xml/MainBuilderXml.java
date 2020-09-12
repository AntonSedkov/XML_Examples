package by.epam.learn.xml;

import by.epam.learn.xml.builder.AbstractStudentsBuilder;
import by.epam.learn.xml.builder.StudentBuilderFactory;

public class MainBuilderXml {

    public static void main(String[] args) {
        String type = "stax";
        AbstractStudentsBuilder builder = StudentBuilderFactory.createStudentBuilder(type);
        builder.buildSetStudents("data_xml/students.xml");
        System.out.println(builder.getStudents());
    }
}
