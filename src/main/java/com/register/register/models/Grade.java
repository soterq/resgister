package com.register.register.models;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double value;
    @OneToOne(mappedBy = "grade", cascade = CascadeType.ALL)
    private Student student;
    @OneToOne(mappedBy = "gradeTeacher", cascade = CascadeType.ALL)
    private Teacher teacher;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "subject_id")
    private Subject subject;

    public void setValue(double value) {
        if (value > 10) {
            value = 10;
        }
        if (value < 0) {
            value = 1;
        }
        this.value = value;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Grade() {
    }
}
