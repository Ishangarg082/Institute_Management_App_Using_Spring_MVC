package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CourseEnrolledDao;
import com.entity.CourseEnrolled;

@Service
public class CourseEnrolledServiceImpl implements CourseEnrolledService{

		@Autowired
	    private CourseEnrolledDao courseEnrolledDao;

	    public CourseEnrolledServiceImpl(CourseEnrolledDao courseEnrolledDao) {
	        this.courseEnrolledDao = courseEnrolledDao;
	    }

	    public List<CourseEnrolled> getAllEnrollments() {
	        return courseEnrolledDao.getAll();
	    }

	    public CourseEnrolled getEnrollmentByRegisterId(String registerId) {
	        return courseEnrolledDao.get(registerId);
	    }

	    public List<CourseEnrolled> getCoursesByRollNumber(String rollNumber) {
	        return courseEnrolledDao.getCoursesByRollNumber(rollNumber);
	    }

	    public List<CourseEnrolled> getStudentsByCourseId(String courseId) {
	        return courseEnrolledDao.getStudentsByCourseId(courseId);
	    }

	    public void deleteEnrollmentByRollNumber(String rollNumber) {
	        courseEnrolledDao.delete(rollNumber);
	    }

	    public void addEnrollment(int registerId, String rollNumber, String courseId) {
	        CourseEnrolled courseEnrolled = new CourseEnrolled();
	        courseEnrolled.setRegisterid(registerId);
	        courseEnrolled.setRollnumber(rollNumber);
	        courseEnrolled.setCourseid(courseId);
	        courseEnrolledDao.add(courseEnrolled);
	    }

	    public void updateEnrollment(String registerId, String rollNumber, String courseId) {
	        CourseEnrolled enrolled = courseEnrolledDao.get(registerId);
	        if(enrolled!=null) {
	        	enrolled.setCourseid(courseId);
	        	enrolled.setRollnumber(rollNumber);
	        	courseEnrolledDao.update(enrolled);
	        }
	    }

	    public void deleteEnrollmentsByCourseId(String courseId) {
	        courseEnrolledDao.deletecourse(courseId);
	    }

}
