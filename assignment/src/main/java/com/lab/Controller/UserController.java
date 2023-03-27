package com.lab.Controller;

import com.lab.Model.User;
import com.lab.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@Configurable
public class UserController {
    @Autowired private UserService service;

    @GetMapping("/users")
    public String showUserList(Model model){
       List<User> listUsers = service.listAll();
       model.addAttribute("listUser",listUsers);
        return "users";
    }

}
