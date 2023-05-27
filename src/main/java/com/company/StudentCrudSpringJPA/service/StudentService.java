package com.company.StudentCrudSpringJPA.service;

import com.company.StudentCrudSpringJPA.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();

    Student findById(Integer id);

    void add(Student student);

    void deleteById(Integer id);

}
