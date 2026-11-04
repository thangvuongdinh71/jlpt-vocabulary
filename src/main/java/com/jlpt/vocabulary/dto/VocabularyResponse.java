package com.jlpt.vocabulary.dto;

import java.time.LocalDateTime;

public class VocabularyResponse {

    private Long id;
    private String word;
    private String reading;
    private String meaning;
    private String level;
    private String example;
    private LocalDateTime createdAt;

    public VocabularyResponse(
            Long id,
            String word,
            String reading,
            String meaning,
            String level,
            String example,
            LocalDateTime createdAt
    ) {
        this.id = id;
        this.word = word;
        this.reading = reading;
        this.meaning = meaning;
        this.level = level;
        this.example = example;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public String getWord() {
        return word;
    }

    public String getReading() {
        return reading;
    }

    public String getMeaning() {
        return meaning;
    }

    public String getLevel() {
        return level;
    }

    public String getExample() {
        return example;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
