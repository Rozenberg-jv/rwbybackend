package com.example.rwbybackend.model.books;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "position_and_district")
public class PositionAndDistrict {

    @Id
    @Column(name = "bind_id", nullable = false)
    private long bindId;
    @Column(name = "position")
    private String position;
    @Column(name = "district_title")
    private String districtTitle;

}
