package com.register.register.service;

import com.register.register.models.Student;
import com.register.register.response.BaseResponse;

import java.util.List;

public interface StudentService {
    Student findStudentById(Long id);
    List<Student> findAll();
    BaseResponse saveToDb(Student  student);
    BaseResponse update(Student  student);
    void delete(Long id);
}
