package com.xuqian.test;


import com.xuqian.domain.Student;
import com.xuqian.service.StudentService;
import com.xuqian.service.impl.StudentServiceImpl;
import com.xuqian.util.ServiceFactory;

import java.util.List;

public class Test1 {

    public static void main(String[] args) {

        //StudentService studentService = new StudentServiceImpl();

        StudentService ss = (StudentService) ServiceFactory.getService(new StudentServiceImpl());
/*
        Student s = new Student();
        s.setId("A0006");
        s.setName("cxk");
        s.setAge(23);

        ss.save(s);
*/
/*
        Student student = ss.getById("A0003");
        System.out.println(student);
*/

        //查询所有记录
        List<Student> sList = ss.getAll();
        for (Student s : sList){

            System.out.println(s);
        }
    }
}
