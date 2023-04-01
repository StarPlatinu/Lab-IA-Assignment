package com.lab.Services;

import com.lab.Model.Curriculum;
import com.lab.Repositories.CurriculumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurriculumService {
    @Autowired
    private CurriculumRepository curriculumRepository;

    public List<Curriculum> getAllCurriculum(){
        return (List<Curriculum>) curriculumRepository.findAll();
    }

    public String save(Curriculum curriculum) {
        curriculumRepository.save(curriculum);
        return "redirect:/curriculums";
    }
}
