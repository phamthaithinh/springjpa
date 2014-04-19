/*
 * devjav [http://devjav.com]
 * Copyright (C) 2014-2014 Pham Thai Thinh
 * Contact:phamthaithinh@gmail.com
 * 
 */
package com.devjav.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author Pham Thai Thinh
 * 
 */
public class PatternValidator {
	private static String PHONE = "[0-9]{10}";
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	public static boolean validateEmail(String email) {
		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}
	public static boolean validatePhone(String phone) {
		Pattern pattern = Pattern.compile(PHONE);
		Matcher matcher = pattern.matcher(phone);
		return matcher.matches();
	}
}
