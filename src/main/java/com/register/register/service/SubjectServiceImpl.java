package com.register.register.service;

import com.register.register.models.Grade;
import com.register.register.models.Subject;
import com.register.register.redpo.SubjectRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepo subjectRepo;
    private final StudentService studentService;
    private final SubjectService subjectService;

    public SubjectServiceImpl(SubjectRepo subjectRepo, StudentService studentService, SubjectService subjectService) {
        this.subjectRepo = subjectRepo;
        this.studentService = studentService;
        this.subjectService = subjectService;
    }

    @Override
    public Subject findSubjectById(Long id) {
        log.info("Find subject with id" + id);
        return subjectRepo.findById(id).get();
    }

    @Override
    public List<Subject> findAll() {
        return subjectRepo.findAll();
    }

    @Override
    public Subject saveToDb(Subject subject) {
        return subjectRepo.save(subject);
    }

    @Override
    public Subject update(Subject subject) {
        return subjectRepo.save(subject);
    }

    @Override
    public void delete(Long id) {
        subjectRepo.deleteById(id);
    }

    @Override
    public Grade setGrade(Long teacherId, Long studentId, int grade) {


        return null;
    }
}
