package com.register.register.service;

import com.register.register.models.Grade;
import com.register.register.models.Student;
import com.register.register.models.Subject;
import com.register.register.models.Teacher;

import java.util.List;

public interface SubjectService {
    Subject findSubjectById(Long id);
    List<Subject> findAll();
    Subject saveToDb(Subject  subject);
    Subject update(Subject  subject);
    void delete(Long id);
    Grade setGrade(Long teacherId, Long studentId, int grade);
}
