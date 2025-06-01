package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.AttendanceDao;
import com.dao.CourseDao;
import com.dao.CourseEnrolledDao;
import com.dao.MarksDao;
import com.entity.Course;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;

    @Autowired
    private CourseEnrolledDao courseEnrolledDao;

    @Autowired
    private AttendanceDao attendanceDao;

    @Autowired
    private MarksDao markDao;

    @Override
    public List<Course> getAllCourses() {
        return courseDao.getall();
    }

    @Override
    public void addCourse(String courseId, String courseName) {
    	Course course = new Course();
    	course.setCourseid(courseId);
    	course.setName(courseName);
        courseDao.add(course);
    }

    @Override
    public void updateCourse(String courseId, String courseName) {
    	Course course = courseDao.get(courseId);
    	if(course!=null) {
    		course.setName(courseName);
    		courseDao.update(course);
    	}
        
    }

    @Override
    public void deleteCourse(String courseId) {
        courseDao.delete(courseId);
        courseEnrolledDao.deletecourse(courseId);
        attendanceDao.deletecourse(courseId);
        markDao.deletecourse(courseId);
    }

    @Override
    public Course getCourse(String courseId) {
        return courseDao.get(courseId);
    }

}
