package com.Guddu.University_Event_Management.repository;


import com.Guddu.University_Event_Management.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepo extends CrudRepository<Student, Integer> {

}
