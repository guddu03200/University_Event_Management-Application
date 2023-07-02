package com.Guddu.University_Event_Management.service;


import com.Guddu.University_Event_Management.model.Department;
import com.Guddu.University_Event_Management.model.Student;
import com.Guddu.University_Event_Management.repository.IStudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    IStudentRepo studentRepo;

    public String addAStudent(Student s) {
        studentRepo.save(s);

        return "Student added !!!";
    }


    public String addStudents(List<Student> s) {
        studentRepo.saveAll(s);

        return "students added";
    }
    public Iterable<Student> getAllStudents() {

        return studentRepo.findAll();
    }


    public Optional<Student> getStudentById(Integer id) {
        return studentRepo.findById(id);
    }

    public String updateStudentDepartment(Integer id, Department department) {
        Optional<Student> s = studentRepo.findById(id);

        if(s.isEmpty()){
            return "Student id not found!!!";
        }

        Student  student = s.get();
        student.setStudentDepartment(department);
        studentRepo.save(student);
        return "Department Updated";
    }

//    public String deleteStudentById(Integer id) {
//        return studentRepo.deleteById(id);
//        return "Student deleted";
//    }
}
