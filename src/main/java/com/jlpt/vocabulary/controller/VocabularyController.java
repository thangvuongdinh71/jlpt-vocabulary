
package com.jlpt.vocabulary.controller;

import com.jlpt.vocabulary.dto.VocabularyRequest;
import com.jlpt.vocabulary.dto.VocabularyResponse;
import com.jlpt.vocabulary.service.VocabularyService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vocabularies")
public class VocabularyController {

    private final VocabularyService vocabularyService;

    public VocabularyController(
            VocabularyService vocabularyService
    ) {
        this.vocabularyService = vocabularyService;
    }

    // Create vocabulary
    @PostMapping
    public ResponseEntity<VocabularyResponse> createVocabulary(
            @Valid @RequestBody VocabularyRequest request
    ) {
        VocabularyResponse response =
                vocabularyService.createVocabulary(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    // Get all vocabularies
    @GetMapping
    public ResponseEntity<List<VocabularyResponse>> getAllVocabularies() {
        return ResponseEntity.ok(
                vocabularyService.getAllVocabularies()
        );
    }

    // Get vocabulary by ID
    @GetMapping("/{id}")
    public ResponseEntity<VocabularyResponse> getVocabularyById(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(
                vocabularyService.getVocabularyByID(id)
        );
    }

    // Update vocabulary
    @PutMapping("/{id}")
    public ResponseEntity<VocabularyResponse> updateVocabulary(
            @PathVariable Long id,
            @Valid @RequestBody VocabularyRequest request
    ) {
        return ResponseEntity.ok(
                vocabularyService.updateVocabulary(id, request)
        );
    }

    // Delete vocabulary
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVocabulary(
            @PathVariable Long id
    ) {
        vocabularyService.deleteVocabulary(id);

        return ResponseEntity.noContent().build();
    }
}
