package com.example.demo.services;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import org.apache.commons.io.FileUtils;
import org.json.CDL;
import org.json.JSONArray;
import org.json.JSONObject;
import org.omg.IOP.Encoding;
import org.springframework.stereotype.Service;
import org.w3c.tidy.EncodingUtils;

import java.io.File;
import java.io.FileReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

    private String prettyfyCsv(String csv) {
        String prettyfiedCsv = "";
//        TODO CSV file editing
//        try {
//            CSVReader reader = new CSVReader(new FileReader("old.csv"));
//            CSVWriter writer = new CSVWriter(new FileWriter("new.csv"));
//            String[] nextLine;
//            while ((nextLine = reader.readNext()) != null) {
//                List<String> lineAsList = new ArrayList<String>(Arrays.asList(nextLine));
//                // Add stuff using linesAsList.add(index, newValue) as many times as you need.
//                writer.writeNext(lineAsList.toArray());
//            }
//        } catch(Exception e) {
//            e.printStackTrace();
//        }

        return prettyfiedCsv;
    }
}
