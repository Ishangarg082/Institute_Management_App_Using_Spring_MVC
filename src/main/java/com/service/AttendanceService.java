package com.service;

import java.util.List;
import com.entity.Attendance;

public interface AttendanceService {
	List<Attendance> getAllAttendance();

	void addAttendance(int id, String rollNumber, String date, String status, String courseId);

	void updateAttendance(String rollNumber, String date, String status, int attendanceId, String courseId);

	List<Attendance> getAttendanceByRoll(String rollNumber);

	List<Attendance> getAttendanceByCourse(String courseId);

	void deleteAttendance(String rollNumber, String courseId, String date);
}
