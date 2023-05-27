package com.company.StudentCrudSpringJPA.dao;

import com.company.StudentCrudSpringJPA.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDao {

    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<Student> getAllStudent() {
        TypedQuery<Student> query = entityManager.createQuery("from Student", Student.class);

        return query.getResultList();

    }

    @Override
    public Student findById(Integer id) {
        Student student = entityManager.find(Student.class, id);
        return student;
    }

    @Override
    public List<Student> findByName(String name) {
        TypedQuery<Student> query = entityManager.createQuery("from Student where firstName=:theName", Student.class);
        query.setParameter("theName", name);
        return query.getResultList();
    }

    @Transactional
    @Override
    public void addStudent(Student student) {
        entityManager.persist(student);
    }

    @Transactional
    @Override
    public void updateStudent(Student student) {
        entityManager.merge(student);
    }

    @Transactional
    @Override
    public void deleteById(Integer id) {
        Student student = findById(id);
        entityManager.remove(student);
    }

    @Transactional
    @Override
    public int deleteALl() {
        int countDeletedRow = entityManager.createQuery("DELETE  from  Student ").executeUpdate();
        return countDeletedRow;
    }
}
