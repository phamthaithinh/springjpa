/*
 * devjav [http://devjav.com]
 * Copyright (C) 2014-2014 Pham Thai Thinh
 * Contact:phamthaithinh@gmail.com
 * 
 */
package com.devjav.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devjav.domain.Employee;
import com.devjav.service.EmployeeService;

/**
 * 
 * @author Pham Thai Thinh
 * 
 */
@Controller
@RequestMapping("/manage/list.do")
public class ListEmployeeController extends BaseController {
	@Autowired
	private EmployeeService employeeService;

	/**
	 * contructor
	 */
	public ListEmployeeController() {
		setSuccessView("list");
	}

	@RequestMapping(method = RequestMethod.GET)
	public String list(Model  model) {
		List<Employee> list=employeeService.listAll();
		model.addAttribute("employees", list);
		model.addAttribute("test", "Hello");
		return getSuccessView();
	}

}
