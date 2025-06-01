package com.service;

import java.util.List;

import com.entity.Fee;

public interface FeeService {
    Fee getFeeByRoll(String rollNumber);
    List<Fee> getFeeByStatus(String status);
    void delete(String rollNumber);
	void add(String rollnumber, String fee, String feestatus);
}
