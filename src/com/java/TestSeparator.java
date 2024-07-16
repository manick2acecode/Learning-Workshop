package com.java;

import java.lang.reflect.InvocationTargetException;

public class TestSeparator {

        public static void main(String[] args) {

            String[] test = "0^~2^~0^~51^~1218^~RA^~SECURONIXUSER".split("\\^\\~");
            //0^~2^~50028^~2^~965^~RT^~CORP\x5CRAMIREZL
            System.out.println("test array lenght "+ test.length);
            for(int i=0;i<test.length;i++){
                System.out.println("test array lenght i "+i+", value : "+ test[i]);
            }
            final String tenantId = test[1];
            final String threatId = test[2];
            final String rgId = test[3];
            final String policyId = test[4];
            final String violator = "TYPE_RT_ACTIVITY_ACCOUNT";
            final String entityId = test[6];
            final String rtId = test[5];
            final String resourceName = "";

    }

}
