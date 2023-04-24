/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.assignment.mavenproject2.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author manicharanreddy
 */
@Controller
public class AssignmentController {
    @GetMapping("/courses/*/assignments/*.htm")
    public String handleGetAssignment(HttpServletRequest request){
        String uri = request.getRequestURI();
        int pos1 = uri.lastIndexOf("/");
        int pos2 = uri.lastIndexOf(".");
        int assignmentId = Integer.parseInt(uri.substring(pos1+1,pos2));
        System.out.println(assignmentId);
        return "assignment-view";
    }
    @PostMapping("/courses/*/assignments/*.htm")
    public String handlePostAssignment(HttpServletRequest request,@RequestParam MultipartFile file){
        String uri = request.getRequestURI();
        int pos1 = uri.lastIndexOf("/");
        int pos2 = uri.lastIndexOf(".");
        int assignmentId = Integer.parseInt(uri.substring(pos1+1,pos2));
        System.out.println(assignmentId);
        return "assignment-view";
    }
}
