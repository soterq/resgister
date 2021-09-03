package com.register.register.service;

import com.register.register.models.Grade;
import com.register.register.models.Student;
import com.register.register.models.Subject;
import com.register.register.models.Teacher;
import com.register.register.redpo.GradeRepo;
import com.register.register.redpo.TeacherRepo;

import java.util.List;

public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepo teacherRepo;
    private final GradeRepo gradeRepo;
    public TeacherServiceImpl(TeacherRepo teacherRepo, GradeRepo gradeRepo) {
        this.teacherRepo = teacherRepo;
        this.gradeRepo = gradeRepo;
    }

    @Override
    public Teacher findTeacherById(Long id) {
        return teacherRepo.findById(id).get();
    }

    @Override
    public List<Teacher> findAll() {
        return teacherRepo.findAll();
    }

    @Override
    public Teacher saveToDb(Teacher teacher) {
        return teacherRepo.save(teacher);
    }

    @Override
    public Teacher update(Teacher teacher) {
        return  teacherRepo.save(teacher);
    }

    @Override
    public void delete(Long id) {
        teacherRepo.deleteById(id);
    }


}
