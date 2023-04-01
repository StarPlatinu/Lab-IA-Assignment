package com.lab.Controller;

import com.lab.Model.Role;
import com.lab.Model.User;
import com.lab.Repositories.RoleRepository;
import com.lab.Repositories.UserRoleRepository;
import com.lab.Services.UserNotFoundEXxception;
import com.lab.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

@Controller
@Configurable
public class UserController {
    @Autowired private UserService service;
    @Autowired private RoleRepository roleRepository;

    @GetMapping("/users")
    public String showUserList(Model model){
       List<User> listUsers = service.listAll();
       model.addAttribute("listUser",listUsers);
        return "users";
    }

    @GetMapping("/users/new")
    public String showNewForm(Model model){
        model.addAttribute("user",new User());
//        model.addAttribute("pageTitle","Add New User");
        return "user_from";
    }

    @PostMapping("/users/save")
    public String saveUser(User user, RedirectAttributes ra){
       service.save(user);
       ra.addFlashAttribute("message","The user has been saved successfully.");
        return "redirect:/users";
    }

    @GetMapping("/users/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id,Model model,RedirectAttributes ra) {
        try {
            User user = service.get(id);
            model.addAttribute("user", user);
//            model.addAttribute("pageTitle","Edit User (ID: "+id+")");
            return "user_from";
        } catch (UserNotFoundEXxception e) {
            ra.addFlashAttribute("message",e.getMessage());
            return "redirect:/users";
        }
    }

    @GetMapping("/users/delete/{id}")
    public String delete(@PathVariable("id") Integer id,RedirectAttributes ra) {
        try {
            service.delete(id);
        ra.addFlashAttribute("message","The user ID "+id+" has been deleted");
        } catch (UserNotFoundEXxception e) {
            ra.addFlashAttribute("message",e.getMessage());
        }
        return "redirect:/users";
    }

    @PostMapping("/login")
    public String loginSuccess(){
        return "redirect:/users";
    }

    // handler method to handle user registration form submit request
    @PostMapping("/register/save")
    public String registration(@ModelAttribute("user") User userDto,
                               BindingResult result,
                               Model model){
        User existingUser = service.findUserByEmail(userDto.getEmail());
        // encrypt the password using spring security

        if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
            result.rejectValue("email", null,
                    "There is already an account registered with the same email");
        }

        if(result.hasErrors()){
            model.addAttribute("user", userDto);
            return "/register";
        }

        service.save(userDto);
        return "redirect:/register?success";
    }

    private Role checkRoleExist(){
        Role role = new Role();
        role.setName("ADMIN");
        return roleRepository.save(role);
    }
}
