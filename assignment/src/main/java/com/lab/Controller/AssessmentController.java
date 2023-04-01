package com.lab.Controller;

import com.lab.Model.Assessment;
import com.lab.Model.Major;
import com.lab.Services.AssessmentService;
import com.lab.Services.MajorService;
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
public class AssessmentController {
    @Autowired
    private AssessmentService service;
    @GetMapping("/assessments")
    public String showUserList(Model model){
        List<Assessment> assessmentList = service.getAllAssessments();
        Assessment assessment = new Assessment();
        model.addAttribute("assessment", assessment);
        model.addAttribute("list",assessmentList);
        return "assessments";
    }

    @PostMapping("/assessments/save")
    public String saveUser(Assessment assessment, RedirectAttributes ra){
        service.save(assessment);
        ra.addFlashAttribute("message","The major has been saved successfully.");
        return "redirect:/assessments";
    }
}
