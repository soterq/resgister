package com.register.register.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "subjects")
    @JoinColumn(name = "subject_id")
    private Set<Student> students;

    @OneToMany(mappedBy = "subject" ,cascade = CascadeType.ALL)
    private List<Grade> grades;

    @OneToOne(mappedBy = "subject", cascade = CascadeType.ALL)
    private ClassBook classBook;
    @ManyToMany
    @JoinTable(
            name = "subject_teachers",
            joinColumns = {@JoinColumn(name = "subject_id")},
            inverseJoinColumns = {@JoinColumn(name = "teacher_id")}
    )
    private List<Teacher>teachers;

    public Subject() {
    }
}
