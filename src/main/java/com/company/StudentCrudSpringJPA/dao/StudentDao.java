package com.company.StudentCrudSpringJPA.dao;

import com.company.StudentCrudSpringJPA.entity.Student;

import java.util.List;

public interface StudentDao {

    List<Student> getAllStudent();

    Student findById(Integer id);

    List<Student> findByName(String name);

    void addStudent(Student student);

    void updateStudent(Student student);

    void deleteById(Integer id);

    int deleteALl();

}
