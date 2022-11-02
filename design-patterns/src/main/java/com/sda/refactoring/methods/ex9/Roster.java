package com.sda.refactoring.methods.ex9;

import java.util.List;

public class Roster {

    String foundStudents(String[] people) {
        List<String> candidates = List.of("Don", "John", "Kent");

        for (String person : people) {
            if (candidates.contains(person)) {
                return person;
            }
        }
        return "";
    }
}
