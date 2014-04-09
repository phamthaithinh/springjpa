/*
 * devjav [http://devjav.com]
 * Copyright (C) 2014-2014 Pham Thai Thinh
 * Contact:phamthaithinh@gmail.com
 * 
 */
package com.devjav.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.devjav.dao.EmployeeDAO;
import com.devjav.domain.Employee;

/**
 * 
 * @author Pham Thai Thinh
 * 
 */
@Component
public class EmployeeService {
	@Autowired
	private EmployeeDAO employeeDAO;

	@Transactional(readOnly = true)
	public List<Employee> listAll() {
		return employeeDAO.listAll();
	}
	@Transactional(rollbackFor = {Exception.class})
	public Employee insert(Employee emp) {
		return employeeDAO.insert(emp);
	}
}
