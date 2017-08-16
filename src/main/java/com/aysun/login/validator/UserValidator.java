package com.aysun.login.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.aysun.login.models.Users;

@Component
public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Users.class.equals(clazz);
	}
	
	@Override
	public void validate(Object object, Errors errors) {
		Users user = (Users) object;
		if (!user.getPasswordConfirmation().equals(user.getPassword())) {
			errors.rejectValue("passwordConfirmation", "Match");
		}
	}
}