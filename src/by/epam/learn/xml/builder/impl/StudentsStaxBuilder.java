package by.epam.learn.xml.builder.impl;

import by.epam.learn.xml.builder.AbstractStudentsBuilder;
import by.epam.learn.xml.entity.Student;

import javax.xml.stream.XMLInputFactory;
import java.util.Set;

public class StudentsStaxBuilder extends AbstractStudentsBuilder {
    private XMLInputFactory inputFactory;

    public StudentsStaxBuilder() {
// more code
    }

    public StudentsStaxBuilder(Set<Student> students) {
        super(students);
// more code
    }

    @Override
    public void buildSetStudents(String fileName) {
// more code
    }
// private methods
}