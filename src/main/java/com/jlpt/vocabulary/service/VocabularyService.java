package com.jlpt.vocabulary.service;


import com.jlpt.vocabulary.dto.VocabularyRequest;
import com.jlpt.vocabulary.dto.VocabularyResponse;
import com.jlpt.vocabulary.entity.Vocabulary;
import com.jlpt.vocabulary.repository.VocabularyRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class VocabularyService {
    private final VocabularyRepository vocabularyRepository;

    public VocabularyService(VocabularyRepository vocabularyRepository) {
        this.vocabularyRepository = vocabularyRepository;
    }

    //Convert Entity to Response DTO
    private VocabularyResponse toRespone(Vocabulary vocabulary) {
        return new VocabularyResponse(
                vocabulary.getId(),
                vocabulary.getWord(),
                vocabulary.getReading(),
                vocabulary.getMeaning(),
                vocabulary.getLevel(),
                vocabulary.getExample(),
                vocabulary.getCreatedAt()
        );
    }

    //create vocabulary
    public VocabularyResponse createVocabulary(VocabularyRequest request) {
        Vocabulary vocabulary = new Vocabulary();
        vocabulary.setWord(request.getWord());
        vocabulary.setReading(request.getReading());
        vocabulary.setMeaning(request.getMeaning());
        vocabulary.setLevel(request.getLevel());
        vocabulary.setExample(request.getExample());

        Vocabulary savedVocabulary = vocabularyRepository.save(vocabulary);

        return toRespone(savedVocabulary);
    }

    //get all vocabularies
    public List<VocabularyResponse> getAllVocabularies() {
        return vocabularyRepository.findAll()
                .stream()
                .map(this::toRespone)
                .toList();
    }

    //get vocabulary by ID
    public VocabularyResponse getVocabularyByID(Long id) {
        Vocabulary vocabulary = vocabularyRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Vocabulary not found by Id" + id
                ));
        return toRespone(vocabulary);
    }

    //update vocabulary
    public VocabularyResponse updateVocabulary(
            Long id,
            VocabularyRequest request
    ){
        Vocabulary vocabulary = vocabularyRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Vocabulary not found with id" + id
                ));
        vocabulary.setWord(request.getWord());
        vocabulary.setReading(request.getReading());
        vocabulary.setMeaning(request.getMeaning());
        vocabulary.setLevel(request.getLevel());
        vocabulary.setExample(request.getExample());

        Vocabulary updatedVocabulary = vocabularyRepository.save(vocabulary);
        return toRespone(updatedVocabulary);
    }

    //delete vocabulary
    public void deleteVocabulary(Long id) {
        if (!vocabularyRepository.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Vocabulary not found with id" + id
            );
        }
        vocabularyRepository.deleteById(id);
    }

}
