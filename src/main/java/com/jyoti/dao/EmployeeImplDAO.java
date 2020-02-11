package com.jyoti.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.jyoti.model.Employee;
@Repository
public class EmployeeImplDAO implements IEmployeeDAO {
@Autowired
HibernateTemplate ht;
	@Override
	public Integer saveEmployee(Employee e) {
		Integer id=(Integer) ht.save(e);
		return id;
	}

}
