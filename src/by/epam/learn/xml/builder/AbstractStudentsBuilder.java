package by.epam.learn.xml.builder;

import by.epam.learn.xml.entity.Student;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractStudentsBuilder {
    // protected - it is often accessed from a subclass
    protected Set<Student> students;

    public AbstractStudentsBuilder() {
        students = new HashSet<Student>();
    }

    public AbstractStudentsBuilder(Set<? extends Student> students) {
        this.students = (Set<Student>) students;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public abstract void buildSetStudents(String filename);
}