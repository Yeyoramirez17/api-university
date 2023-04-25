package com.apiuniversity.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

@Embeddable
public class TeacherSubjectPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "id_teacher")
    private  Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "id_subject")
    private Subject subject;
}
