package com.example.rwbybackend.model.user;

import com.example.rwbybackend.model.ID;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@Data
@ToString(callSuper = true, of = {"role"})
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Role extends ID {

    @Enumerated(EnumType.STRING)
    @Column
    private RoleName role;

}
