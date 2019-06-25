package com.example.demo;

import com.example.demo.services.FileWriter;
import com.example.demo.services.PrintService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.w3c.tidy.Tidy;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@SpringBootApplication
public class HtmlParserDemoApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(HtmlParserDemoApplication.class);

    @Autowired
    private FileWriter fileWriter;

    @Autowired
    private PrintService printService;

    public static void main(String[] args) {
        SpringApplication.run(HtmlParserDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        String url = "";

        Document doc = Jsoup.connect("https://dd-5e-italiano.fandom.com/it/wiki/Tutti_gli_Incantesimi").get();
        Document doc2 = Jsoup.connect("https://dd-5e-italiano.fandom.com/it/wiki/" + url).get();


//        fileWriter.write(doc, "table td a");
//        logger.info("" + printService.print(doc, "table td a"));
//        logger.info("" + printService.print(doc2, "#mw-content-text"));
//        System.out.println(printService.print(doc2, "#mw-content-text"));
//        fileWriter.writeById(doc2, "mw-content-text");

//        System.out.println(printService.printSpellsById(doc2, "mw-content-text"));
//        System.out.println(printService.print(doc, "table td a"));
//        fileWriter.writeById(doc2, "mw-content-text");

    }

}

