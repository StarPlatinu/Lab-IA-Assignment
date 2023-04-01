package com.lab.Controller;

import com.lab.Model.Student;
import com.lab.Model.Teacher;
import com.lab.Services.StudentServices;
import com.lab.Services.TeacherService;
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
public class TeacherController {
    @Autowired
    private TeacherService service;
    @GetMapping("/teachers")
    public String showUserList(Model model){
        List<Teacher> teacherList = service.getAllTeachers();
        Teacher teacher = new Teacher();
        model.addAttribute("teacher", teacher);
        model.addAttribute("list",teacherList);
        return "teachers";
    }

    @PostMapping("/teachers/save")
    public String saveUser(Teacher teacher, RedirectAttributes ra){
        service.save(teacher);
        ra.addFlashAttribute("message","The teacher has been saved successfully.");
        return "redirect:/teachers";
    }
}
