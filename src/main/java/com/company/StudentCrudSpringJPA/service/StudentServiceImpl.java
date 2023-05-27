package com.company.StudentCrudSpringJPA.service;

import com.company.StudentCrudSpringJPA.dao.StudentDao;
import com.company.StudentCrudSpringJPA.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao;

    @Autowired
    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public List<Student> findAll() {
        return studentDao.getAllStudent();
    }

    @Override
    public Student findById(Integer id) {
        return studentDao.findById(id);
    }

    @Override
    public void add(Student student) {
        studentDao.addStudent(student);
    }

    @Override
    public void deleteById(Integer id) {
        studentDao.deleteById(id);
    }
}
