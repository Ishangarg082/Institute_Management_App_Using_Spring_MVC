package com.util;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.entity.Attendance;
import com.entity.Course;
import com.entity.CourseEnrolled;
import com.entity.Marks;
import com.model.StudentConsoleData;
import com.service.AttendanceService;
import com.service.CourseEnrolledService;
import com.service.CourseService;
import com.service.MarksService;

@Component
public class StudentDataMapper{

	@Autowired
	private AttendanceService attendanceService;
	@Autowired
	private CourseEnrolledService courseEnrolledService;

	@Autowired
	private MarksService marksService;

	@Autowired
	private CourseService courseService;

	public List<StudentConsoleData> assemble(String rollNumber) {
		List<CourseEnrolled> enrolledCourses = courseEnrolledService.getCoursesByRollNumber(rollNumber);
		List<Attendance> attendanceList = attendanceService.getAttendanceByRoll(rollNumber);
		List<Marks> marksList = marksService.getMarksByRollNumber(rollNumber);

		List<StudentConsoleData> consoleDataList = new ArrayList<>();

		for (CourseEnrolled enrolled : enrolledCourses) {
			Course course = courseService.getCourse(enrolled.getCourseid());
			if (course == null)
				continue;

			Hibernate.initialize(course.getName());

			StudentConsoleData data = new StudentConsoleData();
			data.setCourseid(course.getCourseid());
			data.setCoursename(course.getName());

			int totalClasses = 0;
			int totalPresent = 0;

			for (Attendance attendance : attendanceList) {
				if (attendance.getCourseid().equals(course.getCourseid())) {
					totalClasses++;
					if (attendance.isPresent()) {
						totalPresent++;
					}
				}
			}

			data.setTotalclasses(totalClasses);
			data.setTotalpresent(totalPresent);

			for (Marks mark : marksList) {
				if (mark.getCourseid().equals(course.getCourseid())) {
					data.setMarks(mark.getMarks());
				}
			}

			consoleDataList.add(data);
		}

		return consoleDataList;
	}

}
