package com.dao;

import java.util.List;

import com.entity.Fee;

public interface FeeDao {
	public void update(Fee fee);

	public Fee getbyroll(String rollnumber);

	public List<Fee> getall();

	public List<Fee> getbypaid(String paid);

	public void add(Fee fee);

	public void delete(String rollnumber);
}
