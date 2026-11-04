package com.jlpt.vocabulary.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "vocabularies")
public class Vocabulary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String word;

    @Column(nullable = false, length = 100)
    private String reading;

    @Column(nullable = false, length = 100)
    private String meaning;

    @Column(length = 20)
    private String level;

    @Column(nullable = true, length = 500)
    private String example;

    private LocalDateTime createdAt;

    public Vocabulary() {
    }

    public Vocabulary(String word,
                      String reading,
                      String meaning,
                      String level,
                      String example) {
        this.word = word;
        this.reading = reading;
        this.meaning = meaning;
        this.level = level;
        this.example = example;
    }

    public Long getId() {
        return id;
    }

    @PrePersist
    public void onCreate() {
        createdAt = LocalDateTime.now();
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
