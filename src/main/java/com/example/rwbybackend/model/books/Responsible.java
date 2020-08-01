package com.example.rwbybackend.model.books;

import com.example.rwbybackend.model.ID;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true, of = {"lastname", "name", "patronym"})
@Table(name = "responsibles_book")
public class Responsible extends ID {

    @Column
    private String lastname;
    @Column
    private String name;
    @Column
    private String patronym;

    @ManyToMany(mappedBy = "responsibles")
    private List<Defectoscope> defectoscopes;

    public String getShortName() {
        return String.format("%s %s1. %s1.",
                lastname, name == null ? "" : name, patronym == null ? "" : patronym);
    }
}


