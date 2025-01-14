package com.Zeotap.SupportAgent.service;



import java.util.Map;

public class NLPService {
    public String findRelevantAnswer(String query, Map<String, String> documentation) {
        for (Map.Entry<String, String> entry : documentation.entrySet()) {
            if (entry.getKey().toLowerCase().contains(query.toLowerCase())) {
                return entry.getValue();
            }
        }
        return "Sorry, I couldn't find an answer for your question.";
    }
}
