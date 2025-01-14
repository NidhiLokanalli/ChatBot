package com.Zeotap.SupportAgent.service;



import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.HashMap;
import java.util.Map;

public class ScraperService {
    public Map<String, String> scrapeDocumentation(String url) throws Exception {
        Map<String, String> data = new HashMap<>();
        Document doc = Jsoup.connect(url).get();

        Elements sections = doc.select("section"); // Adjust selector as per site
        for (Element section : sections) {
            String title = section.select("h2").text();
            String content = section.text();
            data.put(title, content);
        }
        return data;
    }
}
