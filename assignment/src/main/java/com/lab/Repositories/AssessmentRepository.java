package com.lab.Repositories;

import com.lab.Model.Assessment;
import com.lab.Model.Course;
import org.springframework.data.repository.CrudRepository;

public interface AssessmentRepository extends CrudRepository<Assessment,String> {
}
