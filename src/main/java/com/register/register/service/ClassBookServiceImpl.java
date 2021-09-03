package com.register.register.service;

import com.register.register.models.ClassBook;
import com.register.register.models.Student;
import com.register.register.models.Subject;
import com.register.register.redpo.ClassBookRepo;
import com.register.register.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ClassBookServiceImpl implements ClassBookService {
    private final StudentService studentService;
    private final SubjectService subjectService;
    private final ClassBookRepo classBookRepo;

    public ClassBookServiceImpl(StudentService studentService, SubjectService subjectService, ClassBookRepo classBookRepo) {
        this.studentService = studentService;
        this.subjectService = subjectService;
        this.classBookRepo = classBookRepo;
    }


    @Override
    public ClassBook findClassBookById(Long id) {
        log.info("Find class book with id" + id);
        return classBookRepo.findById(id).get();
    }

    @Override
    public List<ClassBook> findAll() {
        log.info("Find all class books");
        return classBookRepo.findAll();
    }

    @Override
    public BaseResponse saveToDb(ClassBook classBook) {
        BaseResponse baseResponse = new BaseResponse();
        if (classBook.getName() == null && !classBook.getName().isEmpty()) {
            baseResponse.setSuccess(false);
            baseResponse.setErrorStatus("400 :Bad Request");
            log.error("400 - Bad Request : Class book Name should be not empty");
            return baseResponse;
        }

        ClassBook bookToSave = new ClassBook();
        for (Student student : classBook.getStudents()) {
            try {
                Student byId = studentService.findStudentById(student.getId());
                bookToSave.getStudents().add(byId);
                log.info("Adding to student with id" + student.getId() + "to class Book" + classBook.getName());
            } catch (Exception e) {
                log.error("Failed to find student with id" + student.getId());
                baseResponse.getErrors().add(" 404 Not Found : student with id" + student.getId());
            }
        }

        for (Subject subject : classBook.getSubjects()) {
            try {
                Subject ById = subjectService.findSubjectById(subject.getId());
                bookToSave.getSubjects().add(ById);
                log.info("Adding to subject with id" + subject.getId() + "to class Book" + classBook.getName());

            } catch (Exception e) {
                log.error("Failed to find subject with id" + subject.getId());
                baseResponse.getErrors().add(" 404 Not Found : subject with id" + subject.getId());

            }
        }
        log.info("Save class book :" + classBook.toString());
        classBookRepo.save(bookToSave);
        baseResponse.setSuccess(true);
        baseResponse.setErrorStatus("200");
        baseResponse.setObjectId(bookToSave.getId().toString());
        baseResponse.setObjectName(bookToSave.getName());
        return baseResponse;
    }

    @Override
    public void delete(Long id) {
        log.info("Delete class book with id : " + id);
        classBookRepo.deleteById(id);
    }

    @Override
    public BaseResponse update(ClassBook classBook) {
        classBookRepo.save(classBook);
        log.info("Update class book {  id :" + classBook.getId() + " , name " + classBook.getName());
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setSuccess(true);
        baseResponse.setObjectId(classBook.getId().toString());
        baseResponse.setObjectName(classBook.getName());
        return baseResponse;
    }
}
