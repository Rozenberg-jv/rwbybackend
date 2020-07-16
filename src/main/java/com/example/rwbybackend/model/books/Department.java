package com.example.rwbybackend.model.books;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "departments")
public class Department {

    @Id
    @Column(name = "id", nullable = false)
    private long id;
    @Column(name = "parent_department_id")
    private int parentDepartmentId;
    @Column(name = "department")
    private String department;

}