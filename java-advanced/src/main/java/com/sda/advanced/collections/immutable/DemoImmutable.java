package com.sda.advanced.collections.immutable;

import java.util.HashMap;
import java.util.Map;

public class DemoImmutable {

    public static void main(String[] args) {
        testMutable();
        System.out.println("---");
        testImmutable();
    }

    private static void testMutable() {
        Map<String, String> mutableCodes = new HashMap<>();
        mutableCodes.put("ro", "40");
        mutableCodes.put("en", "30");

        MutableClass mutableClass = new MutableClass("name", 30, mutableCodes);

        System.out.println(mutableClass.getCodeMap());
        Map<String, String> codeMapClone = mutableClass.getCodeMap();
        codeMapClone.put("us", "50");

        System.out.println(mutableClass.getCodeMap());
    }

    private static void testImmutable() {
        Map<String, String> immutableCodes = new HashMap<>();
        immutableCodes.put("ro", "40");
        immutableCodes.put("en", "30");

        ImmutableClass immutableClass = new ImmutableClass("name", 30, immutableCodes);

        System.out.println(immutableClass.getCodeMap());
        Map<String, String> codeMapClone = immutableClass.getCodeMap();
        codeMapClone.put("us", "50");

        System.out.println(immutableClass.getCodeMap());
    }
}
