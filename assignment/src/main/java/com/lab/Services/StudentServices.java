package com.lab.Services;

import com.lab.Model.Student;
import com.lab.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServices {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents(){
        return (List<Student>) studentRepository.findAll();
    }

    public String save(Student student) {
        studentRepository.save(student);
        return "redirect:/students";
    }
}
