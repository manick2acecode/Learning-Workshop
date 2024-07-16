package com.java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestPattern {

    public static void main(String[] args) {

        //System.out.println(getPipelineNameIndexerFromTopic("qaautomation-enriched"));

        String status = "2";
        System.out.println(status != null && !status.matches("([2|3]).."));


    }

    public static String getPipelineNameIndexerFromTopic(String topicName) {
        final Pattern lastIntPattern = Pattern.compile("[-|_](\\d+)$");
        StringBuilder pipelineName = new StringBuilder("3");
        Matcher matcher = lastIntPattern.matcher(topicName);
        System.out.println(matcher.find());
        if (matcher.find()) {
            String numStr = matcher.group(1);
            if (numStr.startsWith("5") && (numStr.length() == 6)){
                pipelineName.append(numStr.substring(1));
            }
        }
        return pipelineName.toString();
    }
}
