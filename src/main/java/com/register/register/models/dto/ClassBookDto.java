package com.register.register.models.dto;

import com.register.register.models.Student;
import com.register.register.models.Subject;

import java.util.List;
import java.util.Set;

public class ClassBookDto {
    private Long id;
    private String name;
    private List<StudentDto> students;
    private Set<SubjectDto> subjects;
}
