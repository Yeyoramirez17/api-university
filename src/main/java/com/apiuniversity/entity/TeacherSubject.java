package com.apiuniversity.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@IdClass(TeacherSubjectPK.class)
public class TeacherSubject {

    @Id
    private Teacher teacher;

    @Id
    private Subject subject;

    @Column(nullable = false)
    private Integer hours;
}
