package com.service;

import java.util.List;

import com.entity.Marks;

public interface MarksService {
	List<Marks> getMarksByRollNumber(String rollNumber);

	List<Marks> getMarksByCourseId(String courseId);

	void addMark(String rollNumber, String courseId, int marks);

	void deleteMarks(int marksId);

	Marks getMarksById(int marksId);

	void updateMarks(int marksId, String rollNumber, String courseId, int marks);

	void delete(String rollnumber);

	List<Marks> getall();
}
