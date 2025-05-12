package com.guesthousemanagement.guesthousemanagementsystem.dto.guesthouse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GuestHouseResponse {

    private Long guestHouseId;

    private String guestHouseName;

    private LocationResponse location;

    private List<RoomResponse> rooms;
}
