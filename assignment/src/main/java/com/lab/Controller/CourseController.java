package com.lab.Controller;

import com.lab.Model.Course;
import com.lab.Model.Curriculum;
import com.lab.Model.Major;
import com.lab.Services.CourseService;
import com.lab.Services.CurriculumService;
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
public class CourseController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private CurriculumService curriculumService;
    @GetMapping("/courses")
    public String showUserList(Model model){
        List<Curriculum> curriculumList = curriculumService.getAllCurriculum();
        List<Course>  courseList = courseService.getAllCourses();
        Course c = new Course();
        model.addAttribute("course", c);
        model.addAttribute("curriculumList", curriculumList);
        model.addAttribute("courseList",courseList);
        return "courses";
    }

    @PostMapping("/courses/save")
    public String saveUser(Course c, RedirectAttributes ra){
        courseService.save(c);
        ra.addFlashAttribute("message","The curriculum has been saved successfully.");
        return "redirect:/courses";
    }
}
