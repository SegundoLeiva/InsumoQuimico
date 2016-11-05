package controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import domain.Proveedor;

public class ValidatorProveedor implements Validator {
	public boolean supports(Class clazz) {
		// just validate the Customer instances
		return Proveedor.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {

	}

	public void validarProveedor(Object target, Errors errors) {
		// ValidationUtils.rejectIfEmptyOrWhitespace(errors,"desProv",
		// "required.desProv","Debe llenar el Nombre del Proveedor");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "rucProv",
				"required.rucProv", "Debe llenar su Ruc");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dirProv",
				"required.dirProv", "Debe llenar su Dirección");

		Proveedor cust = (Proveedor) target;
		if (!cust.getRucProv().trim().matches("[0-9]*")) {
			errors.rejectValue("rucProv", null, "Debe ingresar solo números");
		}
		if(cust.getDesProv().trim().length()==0){
			errors.rejectValue("desProv", null, "Debe ingresar el nombre");
			
		}

	}

}
