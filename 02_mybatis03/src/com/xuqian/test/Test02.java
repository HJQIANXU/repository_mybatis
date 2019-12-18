package com.xuqian.test;

import com.xuqian.dao.StudentDao;
import com.xuqian.domain.Student;
import com.xuqian.util.SqlSessionUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Test02 {

    public static void main(String[] args) {

        StudentDao studentDao = SqlSessionUtil.getSession().getMapper(StudentDao.class);

        //1、测试parameterType 使用简单数据类型 String
       /* Student s = studentDao.select1("A0001");
        System.out.println(s);*/

       //2、测试parameterType 使用简单数据类型int
        //查询出所有年龄为23岁的学员的详细信息
        /*List<Student> studentList = studentDao.select2(23);

        for (Student student:studentList){
            System.out.println(student);
        }*/

        //3、测试parameterType
        //需求：查询出姓名为wyf，年龄为23岁的学员信息
        /*

            绝对不可以同时为sql语句传递多个参数

         */
        /*List<Student> studentList = studentDao.select3("wyf",23);
        for (Student student:studentList){
            System.out.println(student);
        }*/

        //如果我们要为sql语句传递多个参数，我么应该将这个参数封装到一个domain对象中，或者打包到一个map集合中
        //4、测试parameterType 使用domain为参数  Student s
        /*Student student = new Student();
        student.setName("wyf");
        student.setAge(23);
        List<Student> studentList = studentDao.select4(student);
        for (Student s:studentList){
            System.out.println(s);
        }*/

        //5、测试 parameterType 使用Map为参数
        /*Map<String,Object> map = new HashMap<>();
        map.put("name","wyf");
        map.put("age",23);
        List<Student> studentList = studentDao.select5(map);
        for (Student s:studentList){
            System.out.println(s);
        }*/
        /*
            总结：
               在实际开发中，使用domain应用类型，或者是使用map集合类型都可以为sql语句同时多个传递参数

               在实际项目开发中，一定要学会使用sql传值的这几种方式
         */

        /*List<Student> studentList = studentDao.select7("z");
        for (Student s:studentList){
            System.out.println(s);
        }*/

        //8：测试：resultType 返回String类型
       /* String name = studentDao.select8("A0001");
        System.out.println(name);*/

       //9：测试：resultType 返回String类型集合
        /*List<String> stringList = studentDao.select9();

        for (String name : stringList){
            System.out.println(name);
        }*/

        //10：测试：resultType 返回int类型集合
        //查询：表中一共有多少条信息
        /*Integer count = studentDao.select10();
        System.out.println(count);*/

        //11：测试：resultType 返回HashMap类型集合

        /*
            为什么要使用Map呢
            因为对于查询的结果，使用domain封装不了，所以我们会想到使用map来保存结果
         */

       /* List<Map<String,Object>> mapList = studentDao.select11();

        for (Map<String,Object> map : mapList){

            Set<String> set = map.keySet();
            for (String key : set){
                System.out.println(key + " : " + map.get(key));
            }
            System.out.println("-----------");
        }*/

       //12：测试 resultType 当数据库表字段名称和domain类属性名称不一致时的处理 方式一：起别名
        /*List<Student> studentList = studentDao.select12();
        for (Student s : studentList){
            System.out.println(s);
        }*/

        //13：方式二 使用resultMap
        /*List<Student> studentList = studentDao.select13();
        for (Student s : studentList){
            System.out.println(s);
        }*/

        //测试：动态sql where标签+if标签
        /*Student student = new Student();
        student.setName("y");
        student.setAddress("a");
        List<Student> studentList = studentDao.select14(student);
        for (Student s : studentList){
            System.out.println(s);
        }*/

        //测试：动态sql foreach标签
        String strArr[] = {"A0001","A0002","A0003"};
        List<Student> studentList = studentDao.select15(strArr);
        for (Student s : studentList){
            System.out.println(s);
        }
    }

}
