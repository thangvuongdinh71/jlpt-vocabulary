package com.jlpt.vocabulary.repository;

import com.jlpt.vocabulary.entity.Vocabulary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VocabularyRepository extends JpaRepository<Vocabulary, Long> {
    List<Vocabulary> findByLevel(String level);
    List<Vocabulary> findByWordContainingIgnoreCase(String word);
    List<Vocabulary> findByMeaningContainingIgnoreCase(String meaning);
}
