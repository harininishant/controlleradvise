package com.example.controlleradvice.controller;

import com.example.controlleradvice.domain.Student;
import com.example.controlleradvice.repo.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
//@RequestMapping("/api")
public class StudentController {
    private final StudentRepo repo;


@PostMapping("/student")
    public ResponseEntity<?>createStudent(@RequestBody Student student){
    return ResponseEntity.accepted().body(repo.CreateStudent(student));
}
}
