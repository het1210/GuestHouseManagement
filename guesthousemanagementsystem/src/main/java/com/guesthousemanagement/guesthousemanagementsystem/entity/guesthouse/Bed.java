package com.guesthousemanagement.guesthousemanagementsystem.entity.guesthouse;

import com.guesthousemanagement.guesthousemanagementsystem.enums.AvailabilityStatus;
import com.guesthousemanagement.guesthousemanagementsystem.enums.BedType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Bed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bedId;

    @Column(name = "bed_type")
    @Enumerated(EnumType.STRING)
    private BedType bedType;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private AvailabilityStatus status;

    @ManyToOne
    @JoinColumn(name = "fk_room")
    private Room room;
}
