package com.register.register.service;

import com.register.register.models.Grade;
import com.register.register.models.Student;
import com.register.register.models.Teacher;

import java.util.List;

public interface TeacherService {
    Teacher findTeacherById(Long id);

    List<Teacher> findAll();

    Teacher saveToDb(Teacher teacher);

    Teacher update(Teacher teacher);

    void delete(Long id);


}
