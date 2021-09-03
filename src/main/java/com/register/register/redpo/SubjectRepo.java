package com.register.register.redpo;

import com.register.register.models.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepo extends JpaRepository<Subject, Long> {
    Subject findByName(String name);
}

