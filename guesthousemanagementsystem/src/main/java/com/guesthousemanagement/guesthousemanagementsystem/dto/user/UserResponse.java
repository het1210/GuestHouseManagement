package com.guesthousemanagement.guesthousemanagementsystem.dto.user;

import com.guesthousemanagement.guesthousemanagementsystem.enums.Gender;
import com.guesthousemanagement.guesthousemanagementsystem.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private long userId;

    private String userName;

    private String userEmail;

    private String userMobile;

    private Gender gender;

    private LocalDate dateOfBirth;

    private String address;

    private UserRole userRole;

//    private String employeeId;
//
//    private String employeeDepartment;
}
