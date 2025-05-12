package com.guesthousemanagement.guesthousemanagementsystem.service.impl;

import com.guesthousemanagement.guesthousemanagementsystem.dto.guesthouse.*;
import com.guesthousemanagement.guesthousemanagementsystem.entity.guesthouse.Bed;
import com.guesthousemanagement.guesthousemanagementsystem.entity.guesthouse.GuestHouse;
import com.guesthousemanagement.guesthousemanagementsystem.entity.guesthouse.Location;
import com.guesthousemanagement.guesthousemanagementsystem.entity.guesthouse.Room;
import com.guesthousemanagement.guesthousemanagementsystem.repository.GuestHouseRepository;
import com.guesthousemanagement.guesthousemanagementsystem.service.GuestHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GuestHouseServiceImpl implements GuestHouseService {

    @Autowired
    private GuestHouseRepository guestHouseRepository;

    @Override
    public List<GuestHouseInfo> getAllGuestHouses() {
        List<GuestHouse> guestHouses = guestHouseRepository.findAllGuestHouseDetails();
        List<GuestHouseInfo> guestHouseInfos = new ArrayList<>();

        for(GuestHouse gh : guestHouses){
            guestHouseInfos.add(this.mapGuestHouseToGuestHouseInfo(gh));
        }
        return guestHouseInfos;
    }

    private GuestHouseInfo mapGuestHouseToGuestHouseInfo(GuestHouse gh) {

        GuestHouseResponse guestHouseResponse = new GuestHouseResponse();
        guestHouseResponse.setGuestHouseId(gh.getGuestHouseId());
        guestHouseResponse.setGuestHouseName(gh.getGuestHouseName());
        guestHouseResponse.setLocation(this.mapLocationToLocationResponse(gh.getLocation()));
        guestHouseResponse.setRooms(this.mapRoomsToRoomResponse(gh.getRooms()));

        GuestHouseInfo info = new GuestHouseInfo();
        info.setGuestHouseResponse(guestHouseResponse);
        return info;
    }

    private List<RoomResponse> mapRoomsToRoomResponse(List<Room> rooms) {
        List<RoomResponse> roomResponses = new ArrayList<>();
        for (Room r : rooms){
            RoomResponse roomResponse = new RoomResponse();
            roomResponse.setRoomId(r.getRoomId());
            roomResponse.setRoomName(r.getRoomName());
            roomResponse.setBeds(this.mapBedsToBedResponse(r.getBeds()));
            roomResponses.add(roomResponse);
        }
        return roomResponses;
    }

    private List<BedResponse> mapBedsToBedResponse(List<Bed> beds) {
        List<BedResponse> bedResponses = new ArrayList<>();
        for(Bed b : beds){
            BedResponse bedResponse = new BedResponse();
            bedResponse.setBedId(b.getBedId());
            bedResponse.setBedType((b.getBedType().toString()));
            bedResponse.setStatus(b.getStatus().toString());
            bedResponses.add(bedResponse);
        }
        return bedResponses;
    }

    private LocationResponse mapLocationToLocationResponse(Location location) {
        LocationResponse locationResponse = new LocationResponse();
        locationResponse.setLocationId(location.getLocationId());
        locationResponse.setLocationAddress(location.getLocationAddress());
        locationResponse.setCity(location.getCity());
        locationResponse.setPincode(location.getPincode());
        return locationResponse;
    }
}
