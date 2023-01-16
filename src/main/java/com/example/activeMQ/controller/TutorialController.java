package com.example.activeMQ.controller;

import com.example.activeMQ.dto.request.CreateTutorialRequestDTO;
import com.example.activeMQ.dto.response.CreateTutorialResponseDTO;
import com.example.activeMQ.model.Tutorial;
import com.example.activeMQ.service.TutorialService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TutorialController {

    private final TutorialService tutorialService;

    @PostMapping("/create")
    public ResponseEntity<CreateTutorialResponseDTO> createTutorial(@RequestBody CreateTutorialRequestDTO requestDTO) {
        return tutorialService.createTutorial(requestDTO);
    }

    @GetMapping("/tutorials")
    public ResponseEntity<List<Tutorial>> getAllTutorials() {
        return tutorialService.getAllTutorials();
    }
}
