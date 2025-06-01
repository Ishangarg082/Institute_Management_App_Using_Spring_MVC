package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.FeeDao;
import com.entity.Fee;

@Service
public class FeeServiceImpl implements FeeService {

    @Autowired
    private FeeDao feeDao;

    @Override
    public Fee getFeeByRoll(String rollNumber) {
        return feeDao.getbyroll(rollNumber);
    }

    @Override
    public List<Fee> getFeeByStatus(String status) {
        return feeDao.getbypaid(status);
    }

	@Override
	public void delete(String rollNumber) {
		feeDao.delete(rollNumber);
		
	}

	@Override
	public void add(String rollnumber, String fee, String feestatus) {
		Fee fees = new Fee();
		fees.setFees(feestatus);
		fees.setPaid(feestatus);
		fees.setRollnumber(rollnumber);
		feeDao.add(fees);
	}
}
