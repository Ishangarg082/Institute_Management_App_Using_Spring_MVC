package com.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.entity.Fee;
import com.entity.Student;
import com.model.FeeData;
import com.service.FeeService;
import com.service.StudentService;

@Component
public class FeeDataMapper {

	@Autowired
	private StudentService ss;

	@Autowired
	private FeeService fs;

	public List<FeeData> assembler(String rollnumber) {
		List<FeeData> data = new ArrayList<>();
		FeeData fee = new FeeData();
		Student student = ss.get(rollnumber);
		Fee fees = fs.getFeeByRoll(rollnumber);
		fee.setBranch(student.getBranch());
		fee.setName(student.getName());
		fee.setRollnumber(rollnumber);
		fee.setFees(fees.getFees());
		fee.setPaid(fees.getPaid());
		data.add(fee);
		return data;

	}

	public List<FeeData> assembler2(String status) {
		List<FeeData> data = new ArrayList<>();
		FeeData fee = new FeeData();
		
		List<Fee> fees = fs.getFeeByStatus(status);
		for(Fee feesd : fees) {
			Student student = ss.get(feesd.getRollnumber());
			if(student!=null) {
				fee.setBranch(student.getBranch());
				fee.setName(student.getName());
				fee.setRollnumber(student.getRollnumber());
				fee.setFees(feesd.getFees());
				fee.setPaid(feesd.getPaid());
				data.add(fee);
				
			}	
		}
		return data;

	}

}
