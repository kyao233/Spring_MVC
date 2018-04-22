package com.packt.webstore.validator;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CategoryValidator implements ConstraintValidator<Category, String> {

	
	List<String> allowedCategory = new ArrayList<String>();
	
	@Override
	public void initialize(Category arg0) {
		allowedCategory.add("Computer");
		allowedCategory.add("Phone");
		allowedCategory.add("Light");
		allowedCategory.add("Tablet");
	}

	@Override
	public boolean isValid(String category, ConstraintValidatorContext context) {
		if(!allowedCategory.contains(category)) {
			
			return false;
		}
		return true;
	}

}
