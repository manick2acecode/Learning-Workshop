package com.java;

public class ScoringKeyTest {

    public static void main(String[] args) {

        String scoringKey = "1^~28^~10702^~414^~1878^~A^~HEIJMANS_NL_ROSMALEN_NL_CLOUD_OFFICE365-SHAREPOINT-API|VSLIJPEN@HEIJMANS.NL_1|34|414|HEIJMANS_NL_ROSMALEN_NL_CLOUD_OFFICE365-SHAREPOINT-API|VSLIJPEN@HEIJMANS.NL|SHAREPOINT-EVENTS_1661896800000";
        String[] split = scoringKey.split("\\^\\~");
        System.out.println("split 6th element : "+split[split.length-1]);
        System.out.println(" total lenght : "+split.length);
        String[] entityId = split[split.length-1].split("\\|");
        System.out.println("entityId length : "+entityId.length);
        if(entityId.length == 7){
            System.out.println("entityId 6th element : "+(entityId[4]+"|"+entityId[5]));
        }
    }

}
