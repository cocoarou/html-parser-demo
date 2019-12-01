package com.example.demo;

import com.example.demo.services.JsonToCsvFileWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class HtmlParserDemoApplication extends SpringBootServletInitializer implements CommandLineRunner {

    @Autowired
    JsonToCsvFileWriter jsonToCsvFileWriter;

    Logger log = LoggerFactory.getLogger(HtmlParserDemoApplication.class);

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(HtmlParserDemoApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(HtmlParserDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}

