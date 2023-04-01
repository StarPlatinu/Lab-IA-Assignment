package com.lab.Controller;

import com.lab.Model.Major;
import com.lab.Model.Report;
import com.lab.Services.MajorService;
import com.lab.Services.ReportService;
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
public class ReportController {
    @Autowired
    private ReportService service;
    @GetMapping("/reports")
    public String showUserList(Model model){
        List<Report> reportList = service.getAllReport();
        Report report = new Report();
        model.addAttribute("report", report);
        model.addAttribute("list",reportList);
        return "reports";
    }

    @PostMapping("/reports/save")
    public String saveUser(Report report, RedirectAttributes ra){
        report.calcAverageGrade();
        service.save(report);
        ra.addFlashAttribute("message","The report has been saved successfully.");
        return "redirect:/reports";
    }
}
