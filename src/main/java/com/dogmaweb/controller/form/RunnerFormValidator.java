package com.dogmaweb.controller.form;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class RunnerFormValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return RunnerForm.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        int i = 0;

        // TODO Auto-generated method stub
        // PriceIncrease pi = (PriceIncrease) obj;
        // if (pi == null) {
        // errors.rejectValue("percentage", "error.not-specified", null,
        // "Value required.");
        // }
        // else {
        // logger.info("Validating with " + pi + ": " + pi.getPercentage());
        // if (pi.getPercentage() > maxPercentage) {
        // errors.rejectValue("percentage", "error.too-high",
        // new Object[] {new Integer(maxPercentage)}, "Value too high.");
        // }
        // if (pi.getPercentage() <= minPercentage) {
        // errors.rejectValue("percentage", "error.too-low",
        // new Object[] {new Integer(minPercentage)}, "Value too low.");
        // }
        // }

    }

}
