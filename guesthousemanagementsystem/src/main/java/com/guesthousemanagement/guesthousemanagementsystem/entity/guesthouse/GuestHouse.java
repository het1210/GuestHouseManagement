package com.guesthousemanagement.guesthousemanagementsystem.entity.guesthouse;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class GuestHouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long guestHouseId;

    @Column(name = "guesthouse_name")
    private String guestHouseName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_location")
    private Location location;

    @OneToMany(mappedBy = "guestHouse", cascade = CascadeType.ALL)
    private List<Room> rooms;
}
