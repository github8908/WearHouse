package com.jyoti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jyoti.dao.IEmployeeDAO;
import com.jyoti.model.Employee;
@Service
public class EmployeeServiceImpl implements IEmployeeService {
@Autowired
IEmployeeDAO dao;
   @Transactional
	@Override
	public Integer saveEmployee(Employee e) {
		return dao.saveEmployee(e);
		 
	}

	
}
