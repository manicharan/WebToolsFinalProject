/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.assignment.mavenproject2.controller;

import com.assignment.mavenproject2.dao.CourseDAO;
import com.assignment.mavenproject2.pojo.Course;
import com.assignment.mavenproject2.pojo.User;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author manicharanreddy
 */
@Controller
public class CourseController {
    @GetMapping("/courses/register.htm")
    public String handleGetRegister(HttpServletRequest request,CourseDAO courseDAO){
        HttpSession session = request.getSession();
        User loggedInUser = (User)session.getAttribute("userLoggedIn");
        
        if (loggedInUser == null) {
            return "redirect:/login.htm";
        }
        List<Course> availableCourses = courseDAO.getNonRegisteredCourses(loggedInUser);
        request.setAttribute("availableCourses", availableCourses);

        return "course-register";
    }
    
    @PostMapping("/courses/register.htm")
    public String handleRegistration(HttpServletRequest request,CourseDAO courseDAO){
        HttpSession session = request.getSession();
        User loggedInUser = (User)session.getAttribute("userLoggedIn");
        
        if (loggedInUser == null) {
            return "redirect:/login.htm";
        }
        int courseId = Integer.parseInt(request.getParameter("courseId"));
        courseDAO.registerUserForCourse(courseId, loggedInUser.getId());
        return "course-view";
    }
    
    @GetMapping("/courses/browse.htm")
    public String handleBrowseCourses(HttpServletRequest request,CourseDAO courseDAO){
        List<Course> courses = courseDAO.getAllCourses();
        request.setAttribute("allcourses", courses);
        return "course-view";
    }
    @GetMapping("/courses/view.htm")
    public String handleViewCourses(HttpServletRequest request,CourseDAO courseDAO){
        HttpSession session = request.getSession();
        User loggedInUser = (User)session.getAttribute("userLoggedIn");
        
        if (loggedInUser == null) {
            return "redirect:/login.htm";
        }
        List<Course> courses = courseDAO.getUserCourses(loggedInUser);
        request.setAttribute("registeredCourses", courses);
        return "course-view";
    }
}
