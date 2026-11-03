package com.jlpt.vocabulary.dto;

public class JlptLevelResponse {
        private String level;
        private String name;
        private String description;
        private int estimatedVocabulary;
        private boolean exists;

        public JlptLevelResponse() {

        }
        public JlptLevelResponse(String level,
                                 String name,
                                 String description,
                                 int estimatedVocabulary) {
            this.level = level;
            this.name = name;
            this.description = description;
            this.estimatedVocabulary = estimatedVocabulary;
        }

    public boolean isExists() {
        return exists;
    }

    public String getName() {
        return name;
    }

    public String getLevel() {
        return level;
    }

    public int getEstimatedVocabulary() {
        return estimatedVocabulary;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEstimatedVocabulary(int estimatedVocabulary) {
        this.estimatedVocabulary = estimatedVocabulary;
    }

    public void setExists(boolean exists) {
        this.exists = exists;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
