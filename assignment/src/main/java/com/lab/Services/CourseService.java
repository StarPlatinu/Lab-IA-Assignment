package com.lab.Services;

import com.lab.Model.Course;
import com.lab.Model.Curriculum;
import com.lab.Repositories.CourseRepository;
import com.lab.Repositories.CurriculumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses(){
        return (List<Course>) courseRepository.findAll();
    }

    public String save(Course course) {
        courseRepository.save(course);
        return "redirect:/courses";
    }
}
