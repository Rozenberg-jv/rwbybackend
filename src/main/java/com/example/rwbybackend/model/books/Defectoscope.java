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
@Table(name = "defectoscopes_book")
public class Defectoscope {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;
    @Column
    private String type;
    @Column(name = "factory_number")
    private String factoryNumber;
    @Column(name = "factory_year")
    private LocalDate factoryYear;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "responsible_id")
    private Responsible responsible;

}
