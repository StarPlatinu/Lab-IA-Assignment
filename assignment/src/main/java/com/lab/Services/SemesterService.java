package com.lab.Services;

import com.lab.Model.Semester;
import com.lab.Repositories.SemesterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SemesterService {
    @Autowired
    private SemesterRepository semesterRepository;

    public List<Semester> getAllSemester(){
        return (List<Semester>) semesterRepository.findAll();
    }

    public String save(Semester semester){
        semesterRepository.save(semester);
        return "redirect:/semesters";
    }
}
