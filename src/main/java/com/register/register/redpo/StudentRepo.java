package com.register.register.redpo;

import com.register.register.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Long> {
    Student findByName(String name);
}
