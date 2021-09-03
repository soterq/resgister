package com.register.register.service;

import com.register.register.models.ClassBook;
import com.register.register.response.BaseResponse;

import java.util.List;

public interface ClassBookService {
    ClassBook findClassBookById(Long id);
    List<ClassBook> findAll();
    BaseResponse saveToDb(ClassBook classBook);
    void delete(Long id);
    BaseResponse update(ClassBook classBook);
}
