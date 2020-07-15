package com.example.rwbybackend.model.books;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "stations_book")
public class StationsBook {

    @Id
    @Column(name = "central_station_id", nullable = false)
    private long centralStationId;
    @Column(name = "central_station_title")
    private String centralStationTitle;
    @Column(name = "main_track")
    private int mainTrack;
    @Column(name = "connecting_track")
    private int connectingTrack;

}
