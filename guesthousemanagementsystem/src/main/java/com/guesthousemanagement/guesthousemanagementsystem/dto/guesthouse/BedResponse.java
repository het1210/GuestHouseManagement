package com.guesthousemanagement.guesthousemanagementsystem.dto.guesthouse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BedResponse {
    private long bedId;
    private String bedType;
    private String status;
}
