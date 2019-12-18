package com.xuqian.service.impl;

import com.xuqian.dao.StudentDao;
import com.xuqian.domain.Student;
import com.xuqian.service.StudentService;
import com.xuqian.util.SqlSessionUtil;

import java.util.List;


public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao = SqlSessionUtil.getSession().getMapper(StudentDao.class);
    @Override
    public Student getById(String id) {

        Student s = studentDao.getById(id);
        return s;
    }

    @Override
    public void save(Student s) {

        studentDao.save(s);

    }

    @Override
    public List<Student> getAll() {

        List<Student> sList = studentDao.getAll();
        return sList;
    }
}
