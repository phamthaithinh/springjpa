/*
 * devjav [http://devjav.com]
 * Copyright (C) 2014-2014 Pham Thai Thinh
 * Contact:phamthaithinh@gmail.com
 * 
 */
package com.devjav.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.devjav.form.EmployeeForm;

/**
 * 
 * @author Pham Thai Thinh
 * 
 */
public class EmployeeValidator implements Validator {
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(EmployeeForm.class);
	}

	public void validate(Object form, Errors errors) {
		EmployeeForm employeeForm = (EmployeeForm) form;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName",
				"error.requried", new Object[] { "First name" });
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName",
				"error.requried", new Object[] { "Last name" });

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone",
				"error.requried", new Object[] { "Phone" });
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email",
				"error.requried", new Object[] { "Email" });

		if (!errors.hasFieldErrors("email")) {
			if (!PatternValidator.validateEmail(employeeForm.getEmail())) {
				errors.rejectValue("email", "error.invalid",
						new Object[] { "Email" }, "Email is invalid format");
			}
		}
		if (!errors.hasFieldErrors("phone")) {
			if (!PatternValidator.validatePhone(employeeForm.getPhone())) {
				errors.rejectValue("phone", "error.invalid",
						new Object[] { "Phone" }, "Phone is invalid format");
			}
		}
	}
}
