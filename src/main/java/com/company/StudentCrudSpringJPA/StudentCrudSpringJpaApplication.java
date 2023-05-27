package com.company.StudentCrudSpringJPA;

import com.company.StudentCrudSpringJPA.dao.StudentDao;
import com.company.StudentCrudSpringJPA.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class StudentCrudSpringJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentCrudSpringJpaApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDao studentDao) {
        return runner -> {
            readAllStudent(studentDao);
//            findStudentById(studentDao);
//            findStudentByName(studentDao);
//            createStudent(studentDao);
//            updateStudent(studentDao);
        };
    }

    private void updateStudent(StudentDao studentDao) {
        Student student = studentDao.findById(1);
        student.setFirstName("Sabina");
        studentDao.updateStudent(student);
    }

    private void createStudent(StudentDao studentDao) {
        Student student = new Student("Sigmund", "Freud", "sigmundfreud@gmail.com");
        studentDao.addStudent(student);
    }

    private void findStudentByName(StudentDao studentDao) {
        List<Student> student = studentDao.findByName("Kamala");
        for (Student tempStudent : student) {
            System.out.println(tempStudent);
        }

    }

    private void findStudentById(StudentDao studentDao) {
        Student student = studentDao.findById(2);
        System.out.println(student);
    }


    private void readAllStudent(StudentDao studentDao) {
        System.out.println(studentDao.getAllStudent());
    }


}
