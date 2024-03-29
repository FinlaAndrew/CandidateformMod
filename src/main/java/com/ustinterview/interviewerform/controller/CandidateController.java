package com.ustinterview.interviewerform.controller;

import com.ustinterview.interviewerform.entity.Candidate;
import com.ustinterview.interviewerform.service.CandidateService;
import com.ustinterview.interviewerform.service.ImageDataService;
import com.ustinterview.interviewerform.service.ResumeDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/interview")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @Autowired
    private ImageDataService imageDataService;

    @Autowired
    private ResumeDataService resumeDataService;

    @PostMapping("/candidates")
    public Candidate createCandidate(@RequestBody Candidate candidate) {
        return candidateService.saveCandidate(candidate);
    }

    @PostMapping("/picture")
    public ResponseEntity<?> uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
        String uploadImage = imageDataService.uploadImage(file);
        return ResponseEntity.status(HttpStatus.OK).body(uploadImage);
    }

    @PostMapping("/resume")
    public ResponseEntity<?> uploadResume(@RequestParam("pdf") MultipartFile file) throws IOException {
        String uploadImage = resumeDataService.uploadPdf(file);
        return ResponseEntity.status(HttpStatus.OK).body(uploadImage);
    }


}

