package com.lab.Services;

import com.lab.Model.User;
import com.lab.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
@Autowired private UserRepository repo;
public List<User> listAll(){
    return (List<User>) repo.findAll();
}

    public String save(User user) {
    repo.save(user);
    return "redirect:/users";
    }
    public User get(Integer id) throws UserNotFoundEXxception {
        Optional<User> result = repo.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        throw new UserNotFoundEXxception("Could not find any users with ID"+id);
    }
}
