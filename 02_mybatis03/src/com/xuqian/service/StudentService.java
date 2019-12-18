package com.xuqian.service;

import com.xuqian.domain.Student;

import java.util.List;

public interface StudentService {

    public Student getById(String id);

    public void save(Student s);

    public List<Student> getAll();
}
