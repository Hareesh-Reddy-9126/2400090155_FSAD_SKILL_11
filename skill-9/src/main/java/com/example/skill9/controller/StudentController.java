package com.example.skill9.controller;

import com.example.skill9.model.Student;
import com.example.skill9.service.StudentService;
import com.example.skill9.exception.InvalidInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable String id) {
        try {
            Long studentId = Long.parseLong(id);
            return studentService.getStudentById(studentId);
        } catch (NumberFormatException e) {
            throw new InvalidInputException("Invalid student ID: " + id);
        }
    }
}