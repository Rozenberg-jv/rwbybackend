package com.example.rwbybackend.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name", nullable = false)
    private String firsName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "employeeNumber", nullable = false, unique = true)
    private String employeeNumber;

    @Column(name = "employeePosition", nullable = false)
    private String employeePosition;

    @Column(name = "organizationUnit", nullable = false)
    private String organizationUnit;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate date;


    @Column(name = "enabled", nullable = false)
    private boolean enabled;

}
