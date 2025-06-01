package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.MarksDao;
import com.entity.Marks;

@Service
public class MarksServiceImpl implements MarksService {

    @Autowired
    private MarksDao marksDao;


    @Override
    public List<Marks> getMarksByRollNumber(String rollNumber) {
        return marksDao.getmarksByRollNumber(rollNumber);
    }

    @Override
    public List<Marks> getMarksByCourseId(String courseId) {
        return marksDao.getmarksByCourseId(courseId);
    }

    @Override
    public void addMark(String rollNumber, String courseId, int marks) {
        Marks mark = new Marks();
        mark.setCourseid(courseId);
        mark.setMarks(marks);
        mark.setRollnumber(rollNumber);
        marksDao.add(mark);
    }

    @Override
    public void deleteMarks(int marksId) {
        marksDao.deletemark(marksId);
    }

    @Override
    public Marks getMarksById(int marksId) {
        return marksDao.get(marksId);
    }

    @Override
    public void updateMarks(int marksId, String rollNumber, String courseId, int marks) {
    	Marks mark = marksDao.get(marksId);
    	if(mark!=null) {
    		mark.setCourseid(courseId);
    		mark.setMarks(marks);
    		mark.setRollnumber(rollNumber);
    		marksDao.update(mark);
    	}
        
    }

	@Override
	public void delete(String rollnumber) {
		marksDao.delete(rollnumber);
		
	}

	@Override
	public List<Marks> getall() {
		return marksDao.getall();
		
	}
}
