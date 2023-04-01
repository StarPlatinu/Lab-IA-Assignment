package com.lab.Controller;

import com.lab.Model.Student;
import com.lab.Services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@Configurable
public class StudentController {
    @Autowired
    private StudentServices service;
    @GetMapping("/students")
    public String showUserList(Model model){
        List<Student> studentList = service.getAllStudents();
        Student student = new Student();
        model.addAttribute("student", student);
        model.addAttribute("list",studentList);
        return "students";
    }

    @PostMapping("/students/save")
    public String saveUser(Student student, RedirectAttributes ra){
        service.save(student);
        ra.addFlashAttribute("message","The student has been saved successfully.");
        return "redirect:/students";
    }

}
