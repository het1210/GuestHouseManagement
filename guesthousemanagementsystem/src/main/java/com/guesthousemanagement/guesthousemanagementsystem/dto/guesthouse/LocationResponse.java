package com.guesthousemanagement.guesthousemanagementsystem.dto.guesthouse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationResponse {

    private long locationId;

    private String locationAddress;

    private String city;

    private String pincode;

}
