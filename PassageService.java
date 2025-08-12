package com.example.passagesplitter.service;

import org.apache.hc.client5.http.fluent.Request;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

@Service
public class PassageService {

    public String getPassageFromServer(String url) throws Exception {
        return Request.get(url)
                .connectTimeout(5000)
                .responseTimeout(5000)
                .execute()
                .returnContent()
                .asString(StandardCharsets.UTF_8);
    }

    public List<String> splitPassage(String passage, String mode) {
        switch (mode.toLowerCase()) {
            case "paragraph":
                return Arrays.asList(passage.split("\\n\\n+"));
            case "sentence":
                return Arrays.asList(passage.split("(?<=\\.)\\s+"));
            case "line":
                return Arrays.asList(passage.split("\\n"));
            default:
                throw new IllegalArgumentException("Unsupported split mode: " + mode);
        }
    }
}
