package com.register.register.service;

import com.register.register.models.Student;
import com.register.register.redpo.StudentRepo;
import com.register.register.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService {
    private final StudentRepo studentRepo;

    public StudentServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public Student findStudentById(Long id) {
        log.info("Find student with id" + id);
        return studentRepo.findById(id).get();
    }

    @Override
    public List<Student> findAll() {
        log.info("Find all students");
        return studentRepo.findAll();
    }

    @Override
    public BaseResponse saveToDb(Student student) {
        return validateAndSave(student);

    }

    @Override
    public BaseResponse update(Student student) {
        return validateAndSave(student);
    }

    private BaseResponse validateAndSave(Student student) {
        BaseResponse baseResponse = new BaseResponse();
        if (student.getName().isEmpty()) {
            baseResponse.setSuccess(false);
            baseResponse.setErrorStatus("400 Bad Request");
            baseResponse.getErrors().add("Student name can not be empty");
            log.error("400 Bad Request : Student name can not be empty");
            return baseResponse;
        }
        log.error("Save the student with id : " + student.getId());
        baseResponse.setSuccess(true);
        baseResponse.setObjectId(student.getId().toString());
        baseResponse.setObjectName(student.getName());
        studentRepo.save(student);
        return baseResponse;
    }


    @Override
    public void delete(Long id) {
        log.info("Delete student with id : " + id);
        studentRepo.deleteById(id);
    }
}
