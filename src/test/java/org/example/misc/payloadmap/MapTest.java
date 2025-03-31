package org.example.misc.payloadmap;

import java.util.LinkedHashMap;
import java.util.Map;

public class MapTest {

    public static void main(String[] args) {

        Map<String, Object> Map = new LinkedHashMap<>();
        Map.put("FirstName","Kapil");
        Map.put("LastName","Nalwar");
        Map.put("City","Pune");
        Map.put("Country","India");

        Map<String, Object> AddMap = new LinkedHashMap<>();
        AddMap.put("Street","Viman Nagar");
        AddMap.put("Pin No.","412207");
        Map.put("Address",AddMap);

        System.out.println(Map);



    }
}
