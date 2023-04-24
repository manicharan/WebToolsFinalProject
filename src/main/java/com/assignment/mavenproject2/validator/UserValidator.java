/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.assignment.mavenproject2.validator;
import com.assignment.mavenproject2.pojo.User;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.ValidationUtils;

/**
 *
 * @author manicharanreddy
 */
public class UserValidator implements Validator{
    private static final int MINIMUM_PASSWORD_LENGTH = 8;
    @Override
    public boolean supports(Class<?> type) {
        return User.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "Empty-firstName","FirstName cannot be empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "Empty-lastName","LastName cannot be empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "Empty-email","Email cannot be empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Empty-Password","Password cannot be empty");
        User user = (User) o;
       if (user.getPassword() != null
             && user.getPassword().trim().length() < MINIMUM_PASSWORD_LENGTH) {
          errors.rejectValue("password", "field.min.length",
                new Object[]{Integer.valueOf(MINIMUM_PASSWORD_LENGTH)},
                "The password must be at least [" + MINIMUM_PASSWORD_LENGTH + "] characters in length.");
       }
    }
    
}
