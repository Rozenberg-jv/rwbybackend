package com.example.rwbybackend.model.books;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "defectoscops")
public class Defectoscope {
    @Id
    @Column(nullable = false)
    private long id;
    @Column
    private String type;
    @Column(name = "factory_number")
    private String factoryNumber;
    @Column(name = "factory_year")
    private LocalDate factoryYear;

}
