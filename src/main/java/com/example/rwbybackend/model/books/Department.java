package com.example.rwbybackend.model.books;

import com.example.rwbybackend.model.ID;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true, of = {"parentId", "department"})
@Table(name = "departments_book")
public class Department extends ID {

    @Column(name = "parent_department_id")
    private int parentId;

    @Column(name = "department")
    private String department;

}
