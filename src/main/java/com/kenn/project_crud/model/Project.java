package com.kenn.project_crud.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table(name = "project")
public class Project implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Character difficulty;

    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Dept dept;

    private Long version;

    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    private LocalDate insertTime;

    @UpdateTimestamp
    @Temporal(TemporalType.DATE)
    private LocalDate updateTime;

}
