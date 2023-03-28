package com.lab.Services;

import com.lab.Model.Role;
import com.lab.Model.User;
import com.lab.Repositories.RoleRepository;
import com.lab.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
@Autowired private UserRepository repo;
  @Autowired  private RoleRepository roleRepository;
  //  private PasswordEncoder passwordEncoder;
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

    public void delete(Integer id) throws UserNotFoundEXxception {
        Long count = repo.countById(id);
        if(count == null || count == 0){
            throw new UserNotFoundEXxception("Could not find any users with ID"+id);
        }
        repo.deleteById(id);
    }

    public User get(String email) throws UserNotFoundEXxception {
        Optional<User> result = Optional.ofNullable(repo.findByEmail(email));
        if(result.isPresent()){
            return result.get();
        }
        throw new UserNotFoundEXxception("Email doesn't exist.");
    }

    public User findUserByEmail(String email) {
        return repo.findByEmail(email);
    }

    private Role checkRoleExist(){
        Role role = new Role();
        role.setName("ROLE_ADMIN");
        return roleRepository.save(role);
    }



//    public User getAnUser(String email) throws UserNotFoundEXxception {
//     List<User> list = listAll();
//        for (User user: list) {
//            if(user.getEmail().equals(email))
//                return  user;
//        }
//        throw new UserNotFoundEXxception("Email doesn't exist .");
//    }


}
