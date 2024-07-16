package com.java;

import com.sun.deploy.util.StringUtils;

public class TestStringSplit {

    public static void main(String[] args) {
        String topicName = null;
        String pipeline = "500600";
        if(StringUtils.isEmpty(topicName) && !topicName.contains(pipeline)) {
            System.out.println("inside loop : ");
            String[] parts = topicName.split("-");
            parts[parts.length-1] = pipeline;
            topicName = String.join("-", parts);
        }
        System.out.println("topicName : "+topicName);
    }
}
