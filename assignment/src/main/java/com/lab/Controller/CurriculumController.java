package com.lab.Controller;

import com.lab.Model.Curriculum;
import com.lab.Model.Major;
import com.lab.Services.CurriculumService;
import com.lab.Services.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@Configurable
public class CurriculumController {
    @Autowired
    private CurriculumService service;
    @Autowired
    private MajorService majorService;
    @GetMapping("/curriculums")
    public String showUserList(Model model){
        List<Curriculum> curriculumList = service.getAllCurriculum();
        List<Major>  majorList = majorService.getAllServices();
        Curriculum c = new Curriculum();
        model.addAttribute("curriculum", c);
        model.addAttribute("listMajor", majorList);
        model.addAttribute("list",curriculumList);
        return "curriculums";
    }

    @PostMapping("/curriculums/save")
    public String saveUser(Curriculum c, RedirectAttributes ra){
        service.save(c);
        ra.addFlashAttribute("message","The curriculum has been saved successfully.");
        return "redirect:/curriculums";
    }
}
