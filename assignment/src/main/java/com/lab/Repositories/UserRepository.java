package com.lab.Repositories;
import  com.lab.Model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {
public Long countById(Integer id);
    User findByEmail(String email);
}
