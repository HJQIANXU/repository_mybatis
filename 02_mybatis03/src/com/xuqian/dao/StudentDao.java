package com.xuqian.dao;

import com.xuqian.domain.Student;
import com.xuqian.vo.StudentAndClassroomVo;

import java.util.List;
import java.util.Map;

public interface StudentDao {

    public Student getById(String id);

    public void save(Student s);

    public List<Student> getAll();

    public Student select1(String a0001);

    List<Student> select2(int i);

    List<Student> select4(Student student);

    List<Student> select5(Map<String,Object> map);

    List<Student> select7(String z);

    String select8(String a0001);

    List<String> select9();

    Integer select10();

    List<Map<String,Object>> select11();

    List<Student> select12();

    List<Student> select13();

    List<Student> select14(Student student);

    List<Student> select15(String[] strArr);

    Student select16(String a0001);

    List<Map<String,Object>> select17();

    List<StudentAndClassroomVo> select18();

    List<StudentAndClassroomVo> select19(String z);


    //List<Student> select3(String wyf, int i);
}
