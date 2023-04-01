package com.lab.Services;

import com.lab.Model.Report;
import com.lab.Model.Semester;
import com.lab.Repositories.ReportRepository;
import com.lab.Repositories.SemesterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {
    @Autowired
    private ReportRepository reportRepository;

    public List<Report> getAllReport(){
        return (List<Report>) reportRepository.findAll();
    }

    public String save(Report report){
        reportRepository.save(report);
        return "redirect:/reports";
    }
}
