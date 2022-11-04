package com.sda.advanced.collections.immutable;

import java.util.HashMap;
import java.util.Map;

// class final
public final class ImmutableClass {

    private final String name;
    private final int age;

    private final Map<String, String> codeMap;


    // all args constructor
    public ImmutableClass(String name, int age, Map<String, String> codeMap) {
        this.name = name;
        this.age = age;

        // deep clone of collection
        Map<String, String> tempMap = new HashMap<>();
        for (Map.Entry<String, String> code : codeMap.entrySet()) {
            tempMap.put(code.getKey(), code.getValue());
        }

        this.codeMap = tempMap;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Map<String, String> getCodeMap() {

        // deep clone in getter
        Map<String, String> tempMap = new HashMap<>();
        for (Map.Entry<String, String> code : codeMap.entrySet()) {
            tempMap.put(code.getKey(), code.getValue());
        }
        return tempMap;
    }

    // no setters
}
