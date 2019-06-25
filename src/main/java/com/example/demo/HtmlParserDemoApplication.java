package com.example.demo;

import com.example.demo.models.Spell;
import com.example.demo.services.FileWriter;
import com.example.demo.services.PrintService;
import com.example.demo.services.SpellService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
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

    @Autowired
    private SpellService spellService;

    public static void main(String[] args) {
        SpringApplication.run(HtmlParserDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        String url = "Aiuto";

        Document doc = Jsoup.connect("https://dd-5e-italiano.fandom.com/it/wiki/Tutti_gli_Incantesimi").get();
        Document doc2 = Jsoup.connect("https://dd-5e-italiano.fandom.com/it/wiki/" + url).get();

        ObjectMapper objectMapper = new ObjectMapper();
        Spell spell = spellService.setValuesById(doc2, "mw-content-text");
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.writeValue(new File("spell.json"), spell);


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

