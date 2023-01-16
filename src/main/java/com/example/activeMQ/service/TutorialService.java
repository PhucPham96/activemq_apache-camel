package com.example.activeMQ.service;

import com.example.activeMQ.dto.request.CreateTutorialRequestDTO;
import com.example.activeMQ.dto.response.CreateTutorialResponseDTO;
import com.example.activeMQ.model.Tutorial;
import com.example.activeMQ.repository.TutorialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TutorialService {

    private final TutorialRepository tutorialRepository;

    public ResponseEntity<CreateTutorialResponseDTO> createTutorial(CreateTutorialRequestDTO requestDTO) {
        Tutorial tutorial = new Tutorial();
        tutorial.setDescription(requestDTO.getDescription());
        tutorial.setPublished(Boolean.valueOf(requestDTO.getPublished()));
        tutorial.setTitle(requestDTO.getTitle());
        tutorial = tutorialRepository.save(tutorial);
        CreateTutorialResponseDTO createTutorialResponseDTO = CreateTutorialResponseDTO.builder()
                .id(tutorial.getId().toString())
                .title(tutorial.getTitle())
                .description(tutorial.getDescription())
                .published(tutorial.getPublished().toString())
                .build();
        return ResponseEntity.ok(createTutorialResponseDTO);
    }
}
