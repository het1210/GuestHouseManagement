package com.guesthousemanagement.guesthousemanagementsystem.controller;

import com.guesthousemanagement.guesthousemanagementsystem.dto.guesthouse.GuestHouseInfo;
import com.guesthousemanagement.guesthousemanagementsystem.service.GuestHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/guesthouse")
public class GuestHouseController {

    @Autowired
    private GuestHouseService guestHouseService;

    @GetMapping("/all")
    public ResponseEntity<List<GuestHouseInfo>> getAllGuestHouses(){
        return null;
    }
}
