package com.example.demo.services;

import com.example.demo.models.Spell;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

@Service
public class SpellService {

    public Spell setValuesById(Document doc, String id) {
        Spell spell = new Spell();
        String str = "";

        String content = doc.getElementById(id).outerHtml();
        Document document = Jsoup.parse(content);

        Elements p = document.select("p");
        Elements ul = document.select("ul");

        spell.setSchool(p.get(0).text());
        spell.setCastTime(ul.get(0).text());
        spell.setRange(ul.get(1).text());
        spell.setComponents(ul.get(2).text());
        spell.setDuration(ul.get(3).text());

        for(Integer i = 1; i < p.size(); i++) {
            str += p.get(i).text();
        }

        spell.setDescription(str);

        return spell;
    }

}
