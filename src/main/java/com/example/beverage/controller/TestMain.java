package com.example.beverage.controller;

public class TestMain {

    public static void main(String[] args) {
        System.out.println("Hello World");
        String s = "elephant";
        generateAlternateCaps(s);
    }
    private static void generateAlternateCaps(String s) {

        char[] chars = s.toCharArray();

        for(int i = 0; i < chars.length; i++) {

            if(i % 2 == 0) {
                System.out.print(Character.toUpperCase(chars[i]));
            } else {
                System.out.print(Character.toLowerCase(chars[i]));
            }

        }
    }
}
