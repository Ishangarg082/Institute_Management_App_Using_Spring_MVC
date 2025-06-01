package com.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.entity.Course;
import com.entity.Marks;
import com.entity.Student;
import com.model.MarkData;
import com.service.CourseService;
import com.service.MarksService;
import com.service.StudentService;

@Component
public class MarksDataMapper {
	
	@Autowired
	private MarksService mservice;
	
	@Autowired
	private StudentService ss;
	
	@Autowired
	private CourseService ces;
	
	public List<MarkData> assembler(String rollnumber){
		List<Marks> mark = mservice.getMarksByRollNumber(rollnumber);
		Student student = ss.get(rollnumber);
		List<MarkData> markdata = new ArrayList<>();

		for (Marks marks : mark) {
			Course cs = ces.getCourse(marks.getCourseid());
			MarkData data = new MarkData();
			data.setCourseid(cs.getCourseid());
			data.setCoursename(cs.getName());
			data.setStudentname(student.getName());
			data.setRollnumber(rollnumber);
			data.setMarks(marks.getMarks());
			data.setMarksid(marks.getMarksid());

			markdata.add(data);

		}
		return markdata;
		
	}
	
	public List<MarkData> assembler2(String courseid){
		List<Marks> mark = mservice.getMarksByCourseId(courseid);
		List<MarkData> markdata = new ArrayList<>();

		for (Marks marks : mark) {
			Student student = ss.get(marks.getRollnumber());
			if(student!=null) {
				Course cs = ces.getCourse(marks.getCourseid());
				MarkData data = new MarkData();
				data.setCourseid(cs.getCourseid());
				data.setCoursename(cs.getName());
				data.setStudentname(student.getName());
				data.setRollnumber(marks.getRollnumber());
				data.setMarks(marks.getMarks());
				data.setMarksid(marks.getMarksid());
				markdata.add(data);
			}
		}
		return markdata;
	}
}
