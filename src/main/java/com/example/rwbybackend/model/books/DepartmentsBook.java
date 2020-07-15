package com.example.rwbybackend.model.books;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "departments_book")
public class DepartmentsBook {

    @Id
    @Column(name = "department_id", nullable = false)
    private long departmentId;
    @Column(name = "parent_department_id")
    private int parentDepartmentId;
    @Column(name = "department")
    private String department;

}
