package com.java;

public class TestPitstop {

    public static void main(String[] args) {

        String sparkJobParametersJson = "5pitstop_policyengine-iee.name=Policy_Engine_IEE_5pitstop";
        sparkJobParametersJson = replaceJobNameForIEEPitstop("5pitstop", sparkJobParametersJson);
        System.out.println(sparkJobParametersJson);

    }

    public static String replaceJobNameForIEEPitstop(String pipelineName, String sparkJobParametersJson) {
        String ANA_PITSTOP_SPARK_JOB_NAME = "Policy_Engine_IEE_Pitstop";
        if("5pitstop".equalsIgnoreCase(pipelineName) && !sparkJobParametersJson.contains(ANA_PITSTOP_SPARK_JOB_NAME)){
            return sparkJobParametersJson.replace("Policy_Engine_IEE_"+pipelineName, ANA_PITSTOP_SPARK_JOB_NAME);
        }
        return sparkJobParametersJson;
    }
}
