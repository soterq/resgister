package com.register.register.models.dto;

import java.util.List;

public class SubjectDto {
    private Long id;
    private String name;
    List<TeacherDto> teachers;
    List<GradeDto> grades;
}
