package com.lab.Repositories;

import com.lab.Model.Teacher;
import org.springframework.data.repository.CrudRepository;

public interface TeacherRepository extends CrudRepository<Teacher,String> {
}
