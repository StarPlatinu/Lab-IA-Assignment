package com.lab.Services;

import com.lab.Model.Assessment;
import com.lab.Model.Course;
import com.lab.Repositories.AssessmentRepository;
import com.lab.Repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AssessmentService {
    @Autowired
    private AssessmentRepository assessmentRepository;

    public List<Assessment> getAllAssessments(){
        return (List<Assessment>) assessmentRepository.findAll();
    }

    public String save(Assessment assessment) {
        assessmentRepository.save(assessment);
        return "redirect:/assessments";
    }
}
