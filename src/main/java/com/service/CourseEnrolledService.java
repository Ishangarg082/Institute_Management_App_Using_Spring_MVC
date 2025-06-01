package com.service;

import java.util.List;

import com.entity.CourseEnrolled;

public interface CourseEnrolledService {

	public List<CourseEnrolled> getAllEnrollments();

	public CourseEnrolled getEnrollmentByRegisterId(String registerId);

	public List<CourseEnrolled> getCoursesByRollNumber(String rollNumber);

	public List<CourseEnrolled> getStudentsByCourseId(String courseId);

	public void deleteEnrollmentByRollNumber(String rollNumber);

	public void addEnrollment(int registerId, String rollNumber, String courseId);

	public void updateEnrollment(String registerId, String rollNumber, String courseId);

	public void deleteEnrollmentsByCourseId(String courseId);

}
