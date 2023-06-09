package com.lab.Services;

import com.lab.Model.Role;
import com.lab.Model.User;
import com.lab.Repositories.RoleRepository;
import com.lab.Repositories.UserRepository;
import com.lab.Repositories.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
@Autowired private UserRepository repo;
  @Autowired  private RoleRepository roleRepository;

    @Autowired  private UserRoleRepository userRoleRepository;
  //  private PasswordEncoder passwordEncoder;
public List<User> listAll(){
    return (List<User>) repo.findAll();
}



    public String save(User user) {
    repo.save(user);
    return "redirect:/users";
    }
    public User get(Integer id) throws UserNotFoundException {
        Optional<User> result = repo.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        throw new UserNotFoundException("Could not find any users with ID"+id);
    }

    public void delete(Integer id) throws UserNotFoundException {
        Long count = repo.countById(id);
        if(count == null || count == 0){
            throw new UserNotFoundException("Could not find any users with ID"+id);
        }
        userRoleRepository.deleteById(id);
        repo.deleteById(id);
    }

    public User get(String email) throws UserNotFoundException {
        Optional<User> result = Optional.ofNullable(repo.findByEmail(email));
        if(result.isPresent()){
            return result.get();
        }
        throw new UserNotFoundException("Email doesn't exist.");
    }

    public User findUserByEmail(String email) {
        return repo.findByEmail(email);
    }

    public Role checkRoleExist(){
        Role role = new Role();
        role.setName("ADMIN");
        return roleRepository.save(role);
    }

    public void deleteUserRole(int userId){
      userRoleRepository.deleteById(userId);
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
