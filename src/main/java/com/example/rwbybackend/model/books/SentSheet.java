package com.example.rwbybackend.model.books;

import com.example.rwbybackend.model.actions.ControlEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString(exclude = "controlEntity")
@Entity
@Table(name = "sent_sheet")
public class SentSheet {
    @Id
    @Column(nullable = false)
    private long id;
    @Column
    private LocalDate date;
    @Column(name = "departure_station")
    private String departureStation;
    @Column(name = "destination_station")
    private String destinationStation;
    @Column(name = "place_quantity")
    private int placeQuantity;

    @ManyToOne
    @JoinColumn(name = "control_id")
    private ControlEntity controlEntity;

}
