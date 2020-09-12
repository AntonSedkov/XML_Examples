package by.epam.learn.xml.builder.impl;

import by.epam.learn.xml.builder.AbstractStudentsBuilder;
import by.epam.learn.xml.entity.Student;
import by.epam.learn.xml.handler.StudentHandler;
import org.xml.sax.XMLReader;

import java.util.Set;

public class StudentsSaxBuilder extends AbstractStudentsBuilder {
    private StudentHandler handler;
    private XMLReader reader;

    public StudentsSaxBuilder() { // more code
    }

    public StudentsSaxBuilder(Set<Student> students) {
        super(students);
// more code
    }

    @Override
    public void buildSetStudents(String fileName) {
// more code
    }
// private methods
}