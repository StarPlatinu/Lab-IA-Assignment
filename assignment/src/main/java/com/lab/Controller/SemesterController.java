package com.lab.Controller;

import com.lab.Model.Course;

import com.lab.Model.Curriculum;
import com.lab.Model.Semester;
import com.lab.Services.SemesterService;
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
public class SemesterController {
    @Autowired
    private SemesterService semesterService;

    @GetMapping("/semesters")
    public String showSemesterList(Model model){
        List<Semester> semesterList = semesterService.getAllSemesters();
        Semester s = new Semester();
        model.addAttribute("semester", s);
        model.addAttribute("semesterList",semesterList);
        return "semesters";
    }

    @PostMapping("/semesters/save")
    public String saveSemester(Semester s, RedirectAttributes ra){
        semesterService.save(s);
        ra.addFlashAttribute("message","The semester's information has been saved successfully.");
        return "redirect:/semesters";
    }
}
