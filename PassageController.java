package com.example.passagesplitter.controller;

import com.example.passagesplitter.service.PassageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/passage")
public class PassageController {

    private final PassageService passageService;

    public PassageController(PassageService passageService) {
        this.passageService = passageService;
    }

    @GetMapping("/split")
    public Map<String, Object> splitPassage(
            @RequestParam String url,
            @RequestParam(defaultValue = "paragraph") String mode) throws Exception {

        String passage = passageService.getPassageFromServer(url);
        List<String> sections = passageService.splitPassage(passage, mode);

        return Map.of(
                "sourceUrl", url,
                "splitMode", mode,
                "sectionCount", sections.size(),
                "sections", sections
        );
    }
}
