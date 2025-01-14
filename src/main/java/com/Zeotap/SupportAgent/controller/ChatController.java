package com.Zeotap.SupportAgent.controller;



import com.Zeotap.SupportAgent.service.NLPService;
import com.Zeotap.SupportAgent.service.ScraperService;
import com.Zeotap.SupportAgent.utils.FileUtils;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/chat")
public class ChatController {
    private final NLPService nlpService = new NLPService();
    private Map<String, String> documentation;

    public ChatController() throws Exception {
        // Load or scrape documentation at startup
        ScraperService scraperService = new ScraperService();
        documentation = scraperService.scrapeDocumentation("https://segment.com/docs/");
        FileUtils.saveAsJson(documentation, "segment_docs.json");
    }

    @GetMapping("/ask")
    public String answerQuestion(@RequestParam String question) {
        return nlpService.findRelevantAnswer(question, documentation);
    }
}
