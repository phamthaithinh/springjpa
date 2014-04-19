/*
 * devjav [http://devjav.com]
 * Copyright (C) 2014-2014 Pham Thai Thinh
 * Contact:phamthaithinh@gmail.com
 * 
 */
package com.devjav.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devjav.domain.Employee;
import com.devjav.form.EmployeeForm;
import com.devjav.service.EmployeeService;
import com.devjav.validator.EmployeeValidator;

/**
 * 
 * @author Pham Thai Thinh
 * 
 */
@Controller
@RequestMapping("/manage/add.do")
public class AddEmployeeController extends BaseController {
	@Autowired
	private EmployeeService employeeService;

	/**
	 * Contructor
	 */
	public AddEmployeeController() {
		super();
		setSuccessView("add.emp");
		setRedirectView("redirect:/manage/add.do");
	}

	@RequestMapping(method = RequestMethod.GET)
	public String add(Model model, HttpSession session) {
		if (session.getAttribute("message") != null) {
			model.addAttribute("message", "Insert employee successful.");
			session.removeAttribute("message");
		}
		return getSuccessView();
	}

	@RequestMapping(method = RequestMethod.POST)
	public String process(
			@ModelAttribute("employee") @Valid EmployeeForm employee,
			BindingResult results, HttpSession session) {
		if (results.hasErrors()) {
			return getSuccessView();
		}
		Employee emp = new Employee();
		emp.setEmail(employee.getEmail());
		emp.setPhone(employee.getPhone());
		emp.setLastName(employee.getLastName());
		emp.setFirstName(employee.getFirstName());
		session.setAttribute("message", "Insert employee successful.");
		employeeService.insert(emp);

		return getRedirectView();
	}

	@ModelAttribute(value = "employee")
	public EmployeeForm createModelAttribute() {
		return new EmployeeForm();
	}

	@InitBinder(value = "employee")
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new EmployeeValidator());
	}

}
