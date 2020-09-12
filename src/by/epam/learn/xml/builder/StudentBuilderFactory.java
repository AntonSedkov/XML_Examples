package by.epam.learn.xml.builder;

import by.epam.learn.xml.builder.impl.StudentsDomBuilder;
import by.epam.learn.xml.builder.impl.StudentsSaxBuilder;
import by.epam.learn.xml.builder.impl.StudentsStaxBuilder;

public class StudentBuilderFactory {
    private enum TypeParser {
        SAX, STAX, DOM
    }

    private StudentBuilderFactory() {
    }

    public static AbstractStudentsBuilder createStudentBuilder(String typeParser) {
// insert parser name validation
        TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
        switch (type) {
            case DOM -> {
                return new StudentsDomBuilder();
            }
            case STAX -> {
                return new StudentsStaxBuilder();
            }
            case SAX -> {
                return new StudentsSaxBuilder();
            }
            default -> throw new EnumConstantNotPresentException(
                    type.getDeclaringClass(), type.name());
        }
    }
}
