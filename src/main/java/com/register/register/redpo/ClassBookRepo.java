package com.register.register.redpo;

import com.register.register.models.ClassBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassBookRepo extends JpaRepository<ClassBook, Long> {

    ClassBook findByName(String name);
}
