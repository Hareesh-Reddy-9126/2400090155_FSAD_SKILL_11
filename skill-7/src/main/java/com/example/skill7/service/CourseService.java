package com.example.skill7.service;

import com.example.skill7.model.Course;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class CourseService {
    private final List<Course> courseList = new ArrayList<>();

    public boolean addCourse(Course course) {
        for (Course c : courseList) {
            if (c.getCourseId() == course.getCourseId()) {
                return false;
            }
        }
        courseList.add(course);
        return true;
    }

    public List<Course> getAllCourses() {
        return new ArrayList<>(courseList);
    }

    public Course getCourseById(int id) {
        for (Course c : courseList) {
            if (c.getCourseId() == id) {
                return c;
            }
        }
        return null;
    }

    public boolean updateCourse(int id, Course course) {
        if (course == null) return false;
        for (int i = 0; i < courseList.size(); i++) {
            Course existing = courseList.get(i);
            if (existing != null && existing.getCourseId() == id) {
                // Defensive: copy fields to avoid nulls
                existing.setTitle(course.getTitle() != null ? course.getTitle() : existing.getTitle());
                existing.setDuration(course.getDuration() != null ? course.getDuration() : existing.getDuration());
                existing.setFee(course.getFee());
                return true;
            }
        }
        return false;
    }

    public boolean deleteCourse(int id) {
        return courseList.removeIf(c -> c.getCourseId() == id);
    }

    public List<Course> searchByTitle(String title) {
        List<Course> result = new ArrayList<>();
        if (title == null || title.trim().isEmpty()) return result;
        for (Course c : courseList) {
            if (c.getTitle() != null && c.getTitle().toLowerCase().contains(title.toLowerCase())) {
                result.add(c);
            }
        }
        return result;
    }
}
