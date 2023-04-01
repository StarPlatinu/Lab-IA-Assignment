package com.lab.Services;

import com.lab.Model.Major;
import com.lab.Model.User;
import com.lab.Repositories.MajorRepository;
import com.lab.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MajorService {
    @Autowired
    private MajorRepository majorRepository;

    public List<Major> getAllServices(){
        return (List<Major>) majorRepository.findAll();
    }

    public String save(Major major) {
        majorRepository.save(major);
        return "redirect:/majors";
    }
}
