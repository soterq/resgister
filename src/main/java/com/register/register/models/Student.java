package com.register.register.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String gender;
    private String dateOfBirth;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "classBook_id")
    private ClassBook classBook;
    @ManyToMany
    @JoinTable(
            name = "student_subjects",
            joinColumns = {@JoinColumn(name = "student_id")},
            inverseJoinColumns = {@JoinColumn(name = "subject_id")}
    )
    private Set<Subject> subjects;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Teacher classLeader;

    public Student() {
    }
}
