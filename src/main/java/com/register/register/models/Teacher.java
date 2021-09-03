package com.register.register.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "teacher" ,cascade = CascadeType.ALL)
    private List<Student> students;
    @ManyToMany(mappedBy = "teachers")
    @JoinColumn(name = "subject_id")
    private Set<Subject> subjects;

    public Teacher() {
    }
}
