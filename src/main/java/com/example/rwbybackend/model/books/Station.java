package com.example.rwbybackend.model.books;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "stations")
public class Station {

    @Id
    @Column(nullable = false)
    private long id;
    @Column
    private String title;
    @Column(name = "main_track")
    private int mainTrack;
    @Column(name = "connecting_track")
    private int connectingTrack;

}
