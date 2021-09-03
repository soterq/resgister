package com.register.register.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
public class ClassBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "classBook", cascade = CascadeType.ALL)
    private List<Student> students;
    @OneToMany(mappedBy = "classBookSubject" ,cascade = CascadeType.ALL)
    private Set<Subject> subjects;

    public ClassBook() {
    }
}
