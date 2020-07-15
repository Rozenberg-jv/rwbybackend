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
@Table(name = "defectoscope_book")
public class DefectoscopeBook {
    @Id
    @Column(name = "defectoscope_id", nullable = false)
    private long defectoscopeId;
    @Column(name = "defectoscope_type")
    private String defectoscopeType;
    @Column(name = "factory_number")
    private String factoryNumber;
    @Column(name = "factory_year")
    private LocalDate factoryYear;

}
