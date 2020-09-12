package by.epam.learn.xml.builder.impl;

import by.epam.learn.xml.builder.AbstractStudentsBuilder;
import by.epam.learn.xml.entity.Student;

import javax.xml.parsers.DocumentBuilder;
import java.util.Set;

public class StudentsDomBuilder extends AbstractStudentsBuilder {
    private DocumentBuilder docBuilder;

    public StudentsDomBuilder() {
// more code
    }

    public StudentsDomBuilder(Set<Student> students) {
        super(students);
// more code
    }

    @Override
    public void buildSetStudents(String fileName) {
// more code
    }
// private methods
}
