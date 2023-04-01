package com.lab.Controller;

import com.lab.Model.Major;
import com.lab.Model.User;
import com.lab.Repositories.MajorRepository;
import com.lab.Repositories.UserRoleRepository;
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
public class MajorController {
    @Autowired
    private MajorService service;
    @GetMapping("/majors")
    public String showUserList(Model model){
        List<Major> majorList = service.getAllServices();
        Major major = new Major();
        model.addAttribute("major", major);
        model.addAttribute("list",majorList);
        return "majors";
    }

    @PostMapping("/majors/save")
    public String saveUser(Major major, RedirectAttributes ra){
        service.save(major);
        ra.addFlashAttribute("message","The major has been saved successfully.");
        return "redirect:/majors";
    }
}
