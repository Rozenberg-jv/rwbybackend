package com.example.rwbybackend.model.books;

import com.example.rwbybackend.model.ID;
import com.example.rwbybackend.model.actions.CheckEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

}


