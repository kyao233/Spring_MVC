package com.packt.webstore.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

import com.packt.webstore.domain.Product;

public class ImageSizeValidator implements Validator {

	private long allowedSize = 5 * 1024 * 1024;
	
	
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Product.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Product product = (Product)target;
		MultipartFile imageFile = product.getProductImage();
		long sizeInByte = imageFile.getSize();
		if (sizeInByte > allowedSize) {
			errors.rejectValue("productImage", "com.packt.webstore.validator.ProductImage.message");
		}
	}

}
