package com.guesthousemanagement.guesthousemanagementsystem.entity.guesthouse;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long locationId;

    @Column(name = "address")
    private String locationAddress;

    @Column(name = "city")
    private String city;

    @Column(name = "pincode")
    private String pincode;

    @OneToOne(mappedBy = "location")
    private GuestHouse guestHouse;
}
