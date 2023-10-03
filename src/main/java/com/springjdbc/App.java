package com.springjdbc;

import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDao;
import com.springjdbc.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        //AbstractApplicationContext context = new ClassPathXmlApplicationContext("com/springjdbc/config.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(javaconfig.class);
        System.out.println( "Hello World!" );
        StudentDao temp = context.getBean("studentDao",StudentDao.class);
        //insert
//        Student student = new Student();
//        student.setId(1);
//        student.setName("Tanu");
//        student.setCity("kota");
        
//        int s = temp.insert(student);
//        System.out.println("student added "+s);
        //update
//        Student student = new Student();
//        student.setId(1);
//        student.setName("Tanu Saini");
//        student.setCity("kota Rajashthan");
//        int s = temp.update(student);
//        System.out.println("student upadetd "+s);
        //delete
//        int s = temp.delete(1);
//        System.out.println("student delete "+s);
        
        // select single line
//        Student student = temp.getstudent(2);
//        System.out.println(student);
        
        List<Student> list = temp.Allgetstudent();
        for(Student l :list)
        {
        	System.out.println(l);
        }
    }
}
