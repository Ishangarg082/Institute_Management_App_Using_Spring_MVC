package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.AttendanceDao;
import com.entity.Attendance;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private AttendanceDao attendanceDao;

    @Override
    public List<Attendance> getAllAttendance() {
        return attendanceDao.getall();
    }

    @Override
    public void addAttendance(int id, String rollNumber, String date, String status, String courseId) {
    	Attendance att = new Attendance();
    	att.setRollnumber(rollNumber);
    	att.setCourseid(courseId);
    	att.setDate(date);
    	att.setAttendanceid(id);
    	att.setAttendance(status);
    	
        attendanceDao.add(att);
    }

    @Override
    public void updateAttendance(String rollNumber, String date, String status, int attendanceId, String courseId) {
    	Attendance att = attendanceDao.get(attendanceId);
    	if(att!=null) {
    		att.setAttendance(status);
    		att.setAttendance(status);
    		att.setCourseid(courseId);
    		att.setDate(date);
    		att.setRollnumber(rollNumber);
    		attendanceDao.update(att);
    	}
        
    }

    @Override
    public List<Attendance> getAttendanceByRoll(String rollNumber) {
        return attendanceDao.getbyroll(rollNumber);
    }

    @Override
    public List<Attendance> getAttendanceByCourse(String courseId) {
        return attendanceDao.getbycourse(courseId);
    }

    @Override
    public void deleteAttendance(String rollNumber, String courseId, String date) {
        attendanceDao.delete(rollNumber, courseId, date);
    }
}
