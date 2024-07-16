package com.java;

public class CamelCasingTest {

    public static void main(String[] args) {
        char[] acceptedDelimiters = new char[]{' ', '-', '_'};
        System.out.println(" test :: "+camelCasing("ms office 365", acceptedDelimiters));
    }

    public static String camelCasing(String text, char[] acceptedDelimiters){
        StringBuilder builder = new StringBuilder();
        boolean shouldConvertNextCharToLower = false;
        char delimiter = ' ';
        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            if (containsDelimiter(currentChar, acceptedDelimiters)) {
                shouldConvertNextCharToLower = false;
                builder.append(currentChar);
            } else if (shouldConvertNextCharToLower) {
                builder.append(Character.toLowerCase(currentChar));
            } else {
                builder.append(Character.toUpperCase(currentChar));
                shouldConvertNextCharToLower = true;
            }
        }
        return builder.toString();
    }

    public static boolean containsDelimiter(char currentChar, char[] acceptedDelimiters){
        for (int i = 0; i < acceptedDelimiters.length; i++) {
            if (currentChar == acceptedDelimiters[i])
                return true;
        }
        return false;
    }
}
