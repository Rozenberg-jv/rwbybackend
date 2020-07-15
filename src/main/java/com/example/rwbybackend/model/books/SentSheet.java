package com.example.rwbybackend.model.books;

import com.example.rwbybackend.model.actions.ControlEntity;
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
@Table(name = "sent_sheet")
public class SentSheet {
    @Id
    @Column(name = "sheet_id", nullable = false)
    private long sheetId;
    @Column(name = "sent_Date")
    private LocalDate sentDate;
    @Column(name = "departure_station")
    private String departureStation;
    @Column(name = "destination_station")
    private String destinationStation;
    @Column(name = "place_quantity")
    private int placeQuantity;

    @ManyToOne
    @JoinColumn(name = "control_id", referencedColumnName = "control_id")
    private ControlEntity controlEntityByControlId;

}
