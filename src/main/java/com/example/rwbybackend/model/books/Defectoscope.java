package com.example.rwbybackend.model.books;

import com.example.rwbybackend.model.ID;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true, of = {"type", "factoryNumber", "factoryYear"})
@Entity
@Table(name = "defectoscopes_book")
public class Defectoscope extends ID {

    @Column
    private String type;
    @Column(name = "factory_number")
    private String factoryNumber;
    @Column(name = "factory_year")
    private int factoryYear;

    @ManyToMany
    @JoinTable(name = "responsibles_to_defectoscopes",
            joinColumns = {@JoinColumn(name = "id_responsible")},
            inverseJoinColumns = {@JoinColumn(name = "id_defectoscope")})
    private List<Responsible> responsibles;

}
