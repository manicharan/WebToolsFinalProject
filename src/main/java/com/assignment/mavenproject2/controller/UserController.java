/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.assignment.mavenproject2.controller;

import com.assignment.mavenproject2.dao.UserDAO;
import com.assignment.mavenproject2.pojo.User;
import com.assignment.mavenproject2.validator.UserValidator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;

/**
 *
 * @author manicharanreddy
 */

@Controller
public class UserController {
    
    @GetMapping("/login.htm")
    public String getLogin(ModelMap model,User user){
        model.addAttribute("user", user);
        return "login";
    }
    @PostMapping("/login.htm")
    public String handleLogin(UserValidator userValidator,HttpServletRequest request,@ModelAttribute("user") User user,BindingResult result,SessionStatus status,UserDAO userDao){

        if(userDao.get(user.getEmail())){
            result.rejectValue("email", "Email-not-found","The email doesn't exist");
            return "login";
        }
        User userLoggedIn = userDao.get(user.getEmail(), user.getPassword());
        if(userLoggedIn==null){
            result.rejectValue("password", "User-not-found","The password is wrong");
            return "login";
        }
        System.out.println(userLoggedIn.getEmail());
        HttpSession session = request.getSession();
        session.setAttribute("userLoggedIn", userLoggedIn);
        return "home";        
    }
    
    @GetMapping("/signup.htm")
    public String getSignUp(ModelMap model,User user){
        model.addAttribute("user", user);
        return "signup";
    }
    
    @PostMapping("/signup.htm")
    public String handleSignUp(UserValidator userValidator,HttpServletRequest request,@ModelAttribute("user") User user,BindingResult result,SessionStatus status,UserDAO userDao){
        userValidator.validate(user, result);
        if(result.hasErrors()){
            return "signup";
        }
        status.setComplete();
        if(userDao.get(user.getEmail())){
            userDao.create(user);
            return "redirect:/login.htm";
        }
        else{
            result.rejectValue("email", "Not-unique","Email Id already exists");
            return "signup";
        }
    }
}
