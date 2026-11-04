
package com.jlpt.vocabulary.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class VocabularyRequest {

    @NotBlank(message = "Word is required")
    @Size(max = 100, message = "Word must not exceed 100 characters")
    private String word;

    @NotBlank(message = "Reading is required")
    @Size(max = 100, message = "Reading must not exceed 100 characters")
    private String reading;

    @NotBlank(message = "Meaning is required")
    @Size(max = 100, message = "Meaning must not exceed 100 characters")
    private String meaning;

    @Size(max = 20, message = "Level must not exceed 20 characters")
    private String level;

    @Size(max = 500, message = "Example must not exceed 500 characters")
    private String example;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getReading() {
        return reading;
    }

    public void setReading(String reading) {
        this.reading = reading;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }
}
