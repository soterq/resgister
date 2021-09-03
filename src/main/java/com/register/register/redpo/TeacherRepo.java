package com.register.register.redpo;

import com.register.register.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepo extends JpaRepository<Teacher, Long> {
    Teacher findByName(String name);
}
