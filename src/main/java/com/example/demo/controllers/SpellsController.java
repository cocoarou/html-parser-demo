package com.example.demo.controllers;

import com.example.demo.models.Spell;
import com.example.demo.models.SpellBook;
import com.example.demo.services.JsonToCsvFileWriter;
import com.example.demo.services.PrintService;
import com.example.demo.services.SpellBookService;
import com.example.demo.services.SpellService;
import com.fasterxml.jackson.core.util.DefaultIndenter;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
public class SpellsController {

    Logger log = LoggerFactory.getLogger(SpellsController.class);

    @Autowired
    private PrintService printService;

    @Autowired
    private SpellService spellService;

    @Autowired
    private SpellBookService spellBookService;

    @Autowired
    JsonToCsvFileWriter jsonToCsvFileWriter;

    @RequestMapping(value = "/spells/Antipatia/Simpatia", method = RequestMethod.GET)
    @ResponseBody
    public String antipatiaSimpatia() {

        try {
            ObjectMapper objectMapper = new ObjectMapper();

            Document doc = Jsoup.connect("https://dd-5e-italiano.fandom.com/it/wiki/Antipatia/Simpatia").get();

            Spell s = spellService.setValuesById(doc, "mw-content-text");

            //DefaultPrettyPrinter prettyPrinter = new DefaultPrettyPrinter();
            //prettyPrinter.indentArraysWith(DefaultIndenter.SYSTEM_LINEFEED_INSTANCE);
            //String json = objectMapper.writer(prettyPrinter).writeValueAsString(s);

            return printService.separateSpellDetails(s);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "errore";
    }

    @RequestMapping(value = "/spells/Ingrandire/Ridurre", method = RequestMethod.GET)
    @ResponseBody
    public String ingrandireRidurre() {

        try {
            ObjectMapper objectMapper = new ObjectMapper();

            Document doc = Jsoup.connect("https://dd-5e-italiano.fandom.com/it/wiki/Ingrandire/Ridurre").get();

            Spell s = spellService.setValuesById(doc, "mw-content-text");

            //DefaultPrettyPrinter prettyPrinter = new DefaultPrettyPrinter();
            //prettyPrinter.indentArraysWith(DefaultIndenter.SYSTEM_LINEFEED_INSTANCE);
            //String json = objectMapper.writer(prettyPrinter).writeValueAsString(s);

            return printService.separateSpellDetails(s);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "errore";
    }

    @RequestMapping(value = "/spells/Cecità/Sordità", method = RequestMethod.GET)
    @ResponseBody
    public String cecitaSordita() {

        try {
            ObjectMapper objectMapper = new ObjectMapper();

            Document doc = Jsoup.connect("https://dd-5e-italiano.fandom.com/it/wiki/Cecità/Sordità").get();

            Spell s = spellService.setValuesById(doc, "mw-content-text");

            //DefaultPrettyPrinter prettyPrinter = new DefaultPrettyPrinter();
            //prettyPrinter.indentArraysWith(DefaultIndenter.SYSTEM_LINEFEED_INSTANCE);
            //String json = objectMapper.writer(prettyPrinter).writeValueAsString(s);

            return printService.separateSpellDetails(s);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "errore";
    }

    @RequestMapping(value = "/spells/{spell}", method = RequestMethod.GET)
    @ResponseBody
    public String spell(@PathVariable(name = "spell") String spell) {

        try {
            ObjectMapper objectMapper = new ObjectMapper();

            Document doc = Jsoup.connect("https://dd-5e-italiano.fandom.com/it/wiki/" + spell).get();
            //log.info("" + spell);

            Spell s = spellService.setValuesById(doc, "mw-content-text");

            DefaultPrettyPrinter prettyPrinter = new DefaultPrettyPrinter();
            prettyPrinter.indentArraysWith(DefaultIndenter.SYSTEM_LINEFEED_INSTANCE);
            String json = objectMapper.writer(prettyPrinter).writeValueAsString(s);

            // return printService.separateSpellDetails(s);
            return json;

        } catch (IOException e) {
            System.out.print(spell);
            e.printStackTrace();
            log.info("" + spell);
            log.debug("" + spell);
        }

        return "errore";
    }

    @RequestMapping(value = "/spells", method = RequestMethod.GET)
    @ResponseBody
    public String spellsList() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            Document doc = Jsoup.connect("https://dd-5e-italiano.fandom.com/it/wiki/Tutti_gli_Incantesimi").get();

            SpellBook spellBook = spellBookService.setValuesByCssQuery(doc, "table td a");

            DefaultPrettyPrinter prettyPrinter = new DefaultPrettyPrinter();
            prettyPrinter.indentArraysWith(DefaultIndenter.SYSTEM_LINEFEED_INSTANCE);
            String json = objectMapper.writer(prettyPrinter).writeValueAsString(spellBook);

            return json;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "errore";
    }

    @RequestMapping(value = "/{class}", method = RequestMethod.GET)
    @ResponseBody
    public String classSpecificSpellsList(@PathVariable(name = "class") String spell) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            Document doc = Jsoup.connect("https://dd-5e-italiano.fandom.com/it/wiki/" + spell).get();

            SpellBook spellBook = spellBookService.setValuesByCssQuery(doc, "table td a");
//            DefaultPrettyPrinter prettyPrinter = new DefaultPrettyPrinter();
//            prettyPrinter.indentArraysWith(DefaultIndenter.SYSTEM_LINEFEED_INSTANCE);
//            String json = objectMapper.writer(prettyPrinter).writeValueAsString(spellBook);
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(spellBook);

            try {
                log.info("writing CSV file...");
                JSONObject jsonObject = new JSONObject(json);
                JSONArray ja = jsonObject.getJSONArray("spells");

                for (int i = 0; i < ja.length(); i++) {
                    String sspell = spell(ja.get(i).toString());
                    String spellName = ja.get(i).toString();

                    JSONArray array = new JSONArray();
                    JSONObject item = new JSONObject();

                    item.put(spellName, sspell);
                    array.put(item);

//                    log.info("" + item);
//                    log.info("" + array);

                    jsonToCsvFileWriter.writeFile(array);
                }

            } catch(Exception e) {
                log.info("" + e);
            }

            log.info("done writing CSV file");
            return json.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "errore";
    }

}