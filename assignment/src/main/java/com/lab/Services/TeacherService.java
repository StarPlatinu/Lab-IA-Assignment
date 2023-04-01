package com.lab.Services;

import com.lab.Model.Student;
import com.lab.Model.Teacher;
import com.lab.Repositories.StudentRepository;
import com.lab.Repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    public List<Teacher> getAllTeachers(){
        return (List<Teacher>) teacherRepository.findAll();
    }

    public String save(Teacher teacher) {
        teacherRepository.save(teacher);
        return "redirect:/teachers";
    }
}
