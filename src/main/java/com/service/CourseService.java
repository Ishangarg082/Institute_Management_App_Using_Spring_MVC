package com.service;

import java.util.List;
import com.entity.Course;

public interface CourseService {
    List<Course> getAllCourses();
    void addCourse(String courseId, String courseName);
    void updateCourse(String courseId, String courseName);
    void deleteCourse(String courseId);
    Course getCourse(String courseId);
}
