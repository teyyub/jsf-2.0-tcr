package com.jsfcompref.model;

import static org.junit.Assert.*;

import javax.faces.validator.ValidatorException;

import org.junit.Test;

public class UserBeanTest {

	@Test
	public void validEmail() {
		UserBean bean = new UserBean();
		bean.validateEmail(null, null, "mateusduboli@gmail.com");
	}

	@Test(expected = ValidatorException.class)
	public void invalidEmail() {
		UserBean bean = new UserBean();
		bean.validateEmail(null, null, "thisisnotanemailaddress");
		fail();
	}
	
}
