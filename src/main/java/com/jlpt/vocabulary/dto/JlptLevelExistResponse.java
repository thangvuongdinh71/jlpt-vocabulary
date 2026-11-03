package com.jlpt.vocabulary.dto;

public class JlptLevelExistResponse {
    private String level;
    private boolean exists;

    public JlptLevelExistResponse(String level, boolean exists) {
        this.level = level;
        this.exists = exists;
    }

    public String getLevel() {
        return level;
    }

    public boolean isExists() {
        return exists;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setExists(boolean exists) {
        this.exists = exists;
    }
}
