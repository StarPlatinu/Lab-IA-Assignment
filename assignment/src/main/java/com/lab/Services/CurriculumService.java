package com.lab.Services;

import com.lab.Model.Curriculum;
import com.lab.Model.Major;
import com.lab.Repositories.MajorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurriculumService {
    @Autowired
    private CurriculumService curriculumService;

    public List<Curriculum> getAllCurriculum(){
        return  curriculumService.getAllCurriculum();
    }

    public String save(Curriculum curriculum) {
        curriculumService.save(curriculum);
        return "redirect:/curriculums";
    }
}
