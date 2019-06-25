package com.example.demo.controllers;

import com.example.demo.models.Spell;
import com.example.demo.services.PrintService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
public class SpellsController {

    @Autowired
    private PrintService printService;

    @RequestMapping(value = "/showspells", method = RequestMethod.GET)
    @ResponseBody
    public String spellsList() {
        Document doc = null;
        try {
            doc = Jsoup.connect("https://dd-5e-italiano.fandom.com/it/wiki/Tutti_gli_Incantesimi").get();
            return printService.print(doc, "table td a");
        } catch (IOException e) {
            e.printStackTrace();

        }
        return "error";
    }

}
