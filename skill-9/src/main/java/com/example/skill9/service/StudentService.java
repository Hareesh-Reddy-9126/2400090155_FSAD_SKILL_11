package com.example.skill9.service;

import com.example.skill9.model.Student;
import com.example.skill9.exception.StudentNotFoundException;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final List<Student> students = new ArrayList<>();

    @PostConstruct
    public void init() {
        students.add(new Student(1L, "John", "CSE"));
        students.add(new Student(2L, "Alice", "IT"));
        students.add(new Student(3L, "Robert", "ECE"));
    }

    public Student getStudentById(Long id) {
        Optional<Student> student = students.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst();
        if (student.isPresent()) {
            return student.get();
        } else {
            throw new StudentNotFoundException("Student with ID " + id + " not found");
        }
    }
}