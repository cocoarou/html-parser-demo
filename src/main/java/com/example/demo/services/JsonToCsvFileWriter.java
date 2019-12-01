package com.example.demo.services;

import org.apache.commons.io.FileUtils;
import org.json.CDL;
import org.json.JSONArray;
import org.json.JSONObject;
import org.omg.IOP.Encoding;
import org.springframework.stereotype.Service;
import org.w3c.tidy.EncodingUtils;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

@Service
public class JsonToCsvFileWriter {

    public void writeFile() {

        String json = "{\"infile\": [{\"field1\": 11,\"field2\": 12,\"field3\": 13},{\"field1\": 21,\"field2\": 22,\"field3\": 23},{\"field1\": 31,\"field2\": 32,\"field3\": 33}]}";

        JSONObject output;
        try {
            output = new JSONObject(json);


            JSONArray docs = output.getJSONArray("infile");

            File file = new File("fromJSON.csv");

            String csv = CDL.toString(docs);

            FileUtils.writeStringToFile(file, csv);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeFile(JSONArray jsonArray) {

        try {
            File file = new File("fromJSON.csv");

            String csv = CDL.toString(jsonArray);

            FileUtils.writeStringToFile(file, csv, StandardCharsets.UTF_8, true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
