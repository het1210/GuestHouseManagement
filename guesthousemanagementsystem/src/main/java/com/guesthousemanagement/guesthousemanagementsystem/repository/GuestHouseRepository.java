package com.guesthousemanagement.guesthousemanagementsystem.repository;

import com.guesthousemanagement.guesthousemanagementsystem.entity.guesthouse.GuestHouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuestHouseRepository extends JpaRepository<GuestHouse, Long> {

    @Query( "SELECT DISTINCT gh FROM GuestHouse gh " +
            "LEFT JOIN gh.location l " +
            "LEFT JOIN gh.rooms r " +
            "LEFT JOIN r.beds")
    List<GuestHouse> findAllGuestHouseDetails();
}
