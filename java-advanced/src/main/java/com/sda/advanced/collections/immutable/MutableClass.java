package com.sda.advanced.collections.immutable;

import java.util.Map;

public class MutableClass {

    private String name;
    private int age;

    private Map<String, String> codeMap;


    public MutableClass(String name, int age, Map<String, String> codeMap) {
        this.name = name;
        this.age = age;
        this.codeMap = codeMap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Map<String, String> getCodeMap() {
        return codeMap;
    }

    public void setCodeMap(Map<String, String> codeMap) {
        this.codeMap = codeMap;
    }

}
