package com.jlpt.vocabulary.controller;

import com.jlpt.vocabulary.dto.JlptLevelExistResponse;
import com.jlpt.vocabulary.dto.JlptLevelResponse;
import com.jlpt.vocabulary.service.JlptLevelService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {
    private final JlptLevelService jlptLevelService;

    public HelloController(JlptLevelService jlptLevelService) {
        this.jlptLevelService = jlptLevelService;
    }

    @GetMapping("/api/hello")
    public String hello() {
        return "Welcome to JLPT Vocabulary System!";
    }

    @GetMapping("api/greeting")
    public String greeting() {
        return "Hello! Welcome to learning Japanese.";
    }

    @GetMapping("api/jlpt/levels/{level}")
    public JlptLevelResponse getJlptLevel(@PathVariable String level) {
        return jlptLevelService.getJlptLevel(level);
    }

    @GetMapping("api/jlpt/levels")
    public List<JlptLevelResponse> getJlptLevels() {
        return jlptLevelService.getJlptLevels();
    }

    @GetMapping("api/jlpt/levels/{level}/exists")
    public JlptLevelExistResponse Exists(@PathVariable String level) {
        return jlptLevelService.findExists(level);
    }
}
