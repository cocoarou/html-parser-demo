package com.example.demo.services;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

@Service
public class PrintService {

    private static String log(String msg, String... vals) {
        return String.format(msg, vals);
    }

    public String print(Document doc, String cssQuery) {
        String str = doc.title() + "\n";

        Elements elements = doc.select(cssQuery);

        for(Element element : elements) {
            str += log("%s\n\t%s\n", element.attr("title"), element.absUrl("href"));
        }
        return str;
    }

    public String printSpellsById(Document doc, String id) {
        String str = doc.title() + "\n";

        String content = doc.getElementById(id).outerHtml();
        Document document = Jsoup.parse(content);

        Elements p = document.select("p");
        Elements ul = document.select("ul");

        str += p.get(0).text() + "\n";
        for(Element e : ul) {
            str += e.text() + "\n";
        }
        for(int i = 1; i < p.size(); i++) {
            str += p.get(i).text();
        }

        return str;

    }
}
