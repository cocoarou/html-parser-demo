package com.example.demo;

import com.example.demo.models.Spell;
import com.example.demo.models.SpellBook;
import com.example.demo.services.FileWriter;
import com.example.demo.services.PrintService;
import com.example.demo.services.SpellBookService;
import com.example.demo.services.SpellService;
import com.fasterxml.jackson.core.util.DefaultIndenter;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
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

    @Autowired
    private SpellBookService spellBookService;

    public static void main(String[] args) {
        SpringApplication.run(HtmlParserDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {



    }

}

