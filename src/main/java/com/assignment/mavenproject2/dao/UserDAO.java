/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.assignment.mavenproject2.dao;

import com.assignment.mavenproject2.pojo.User;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;

/**
 *
 * @author manicharanreddy
 */
public class UserDAO extends DAO {

    public UserDAO() {
    }

    public User get(String username,String password){
        try {

               begin();
               Query q = getSession().createQuery("from User where email= :email and password= :password");
               q.setParameter("email", username);
               q.setParameter("password", password);
               q.setComment("User Fetch Query");
               User user = (User) q.uniqueResult();
               commit();
               return user;

        } catch (HibernateException e) {
            rollback();
            System.out.println("Exception :" + e.getMessage());
        }
        return null;
//         return new User("Mani","Loka","manicharanreddy@gmail.com","password");    	
    }
    public boolean create(User user) {
        try {
            //save user object in the database
        	begin();
        	getSession().save(user);
        	commit();
        	close();
        	
        	return true;
        } catch (HibernateException e) {
            rollback();
            System.out.println("Exception :" + e.getMessage());
        }
        return false;    
    }

//    public void delete(User user) throws UserException {
//    	 try {
//             //save user object in the database
//         	begin();
//         	getSession().delete(user);
//         	commit();
//         	
//         } catch (HibernateException e) {
//             rollback();
//             //throw new AdException("Could not create user " + username, e);
//             throw new UserException("Exception while deleting user: " + e.getMessage());
//         }
//    }
    
//    public List<String> list() throws CategoryException {
//        List<String> list1 = new ArrayList<>();
//        try {
//            begin();
//        	Query query = getSession().createQuery("from User");
//                List<User> list = query.list();
//                for(User c: list){
//                list1.add(c.getName());}
//        	commit();
//        	close();
//        	
//        	return list1;
//            //save advertisement to the database
//        } catch (HibernateException e) {
//            rollback();
//            //throw new AdException("Could not create advert", e);
//            throw new CategoryException("Exception while getting Category: " + e.getMessage());
//        }
//    }

    public boolean get(String email) {
        Query q = getSession().createQuery("from User where email= :email");
        q.setParameter("email", email);
        q.setComment("User Email Query");
        List<User> users = q.list();
        return users.isEmpty();
    }
}
