package com.example.demo;

import com.example.demo.services.FileWriter;
import com.example.demo.services.PrintService;
import com.example.demo.services.SpellBookService;
import com.example.demo.services.SpellService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

