/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.assignment.mavenproject2.dao;

import com.assignment.mavenproject2.pojo.Course;
import com.assignment.mavenproject2.pojo.User;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

/**
 *
 * @author manicharanreddy
 */
public class CourseDAO extends DAO{

    public List<Course> getCoursesForUser(User loggedInUser) {
        return new ArrayList<>();
    }
    public List<Course> getAllCourses() {
        try {
            begin();
            Query query = getSession().createQuery("FROM Course");
            commit();
            return query.list();
        } catch (Exception e) {
            rollback();
            System.out.println("Exception :" + e.getMessage());
        } 
        return new ArrayList<>();
    }
    public void registerUserForCourse(int courseId, int userId) {
        try {
            begin();
            Course course = getSession().get(Course.class, courseId);
            User user = getSession().get(User.class, userId);

            course.getUsers().add(user);
            user.getCourses().add(course);
            getSession().merge(user);
            getSession().merge(course);
            commit();
            close();
        } catch (Exception e) {
            rollback();
            System.out.println("Exception :" + e.getMessage());
        } 
    }

    public List<Course> getNonRegisteredCourses(User loggedInUser) {
        try {
            begin();
//            Criteria courCrit = getSession().createCriteria(Course.class);
//            Criteria userCrit = courCrit.createCriteria("users");
////            userCrit.add(Restrictions.ne("id", loggedInUser.getId()));
//            userCrit.add(Restrictions.not(Restrictions.eq("id", loggedInUser.getId())));
////            Query query = getSession().createQuery("FROM Course where ");
//            return userCrit.list();
            String hql = "FROM Course c WHERE :loggedInUserId NOT IN (SELECT u.id FROM c.users u)";
            Query query = getSession().createQuery(hql);
            query.setParameter("loggedInUserId", loggedInUser.getId());
            commit();
            return query.list();
        } catch (Exception e) {
            rollback();
            System.out.println("Exception :" + e.getMessage());
        } 
        return new ArrayList<>();
    }

    public List<Course> getUserCourses(User loggedInUser) {
    try {
        begin();
        Criteria courCrit = getSession().createCriteria(Course.class);
        Criteria userCrit = courCrit.createCriteria("users");
        userCrit.add(Restrictions.eq("id", loggedInUser.getId()));
        commit();
//            userCrit.add(Restrictions.not(Restrictions.eq("id", loggedInUser.getId())));
////            Query query = getSession().createQuery("FROM Course where ");
        return userCrit.list();
        } catch (Exception e) {
        rollback();
        System.out.println("Exception :" + e.getMessage());
        } 
        return new ArrayList<>();
    }
    
}
