package com.example.skill7.controller;

import com.example.skill7.model.Course;
import com.example.skill7.service.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping
    public ResponseEntity<String> addCourse(@RequestBody(required = false) Course course) {
        if (course == null || course.getTitle() == null || course.getTitle().trim().isEmpty() || course.getDuration() == null) {
            return new ResponseEntity<>("Invalid course data", HttpStatus.BAD_REQUEST);
        }
        boolean added = courseService.addCourse(course);
        if (added) {
            return new ResponseEntity<>("Course added successfully", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Course ID already exists", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        return new ResponseEntity<>(courseService.getAllCourses(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCourseById(@PathVariable int id) {
        Course course = courseService.getCourseById(id);
        if (course == null) {
            return new ResponseEntity<>("Course not found", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(course);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCourse(@PathVariable int id, @RequestBody(required = false) Course course) {
        if (course == null || course.getTitle() == null || course.getTitle().trim().isEmpty() || course.getDuration() == null) {
            return new ResponseEntity<>("Invalid course data", HttpStatus.BAD_REQUEST);
        }
        try {
            boolean updated = courseService.updateCourse(id, course);
            if (updated) {
                return new ResponseEntity<>("Course updated successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Course not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Internal error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable int id) {
        boolean deleted = courseService.deleteCourse(id);
        if (deleted) {
            return new ResponseEntity<>("Course deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Course not found", HttpStatus.NOT_FOUND);
        }
    }

    // Support both /courses/search/{title} and /courses/search?keyword=title
    @GetMapping({"/search/{title}", "/search"})
    public ResponseEntity<?> searchByTitle(
            @PathVariable(value = "title", required = false) String title,
            @RequestParam(value = "keyword", required = false) String keyword) {
        String searchTerm = (title != null) ? title : keyword;
        if (searchTerm == null || searchTerm.trim().isEmpty()) {
            return new ResponseEntity<>("Missing or empty search term", HttpStatus.BAD_REQUEST);
        }
        List<Course> found = courseService.searchByTitle(searchTerm);
        return new ResponseEntity<>(found, HttpStatus.OK);
    }
}
