package com.guesthousemanagement.guesthousemanagementsystem.entity.user;

import com.guesthousemanagement.guesthousemanagementsystem.enums.Gender;
import com.guesthousemanagement.guesthousemanagementsystem.enums.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    @Column(name = "userName", nullable = false)
    private String userName;

    @Email
    @Column(name ="userEmail", nullable = false, unique = true)
    private String userEmail;

    @Column(name = "mobileNumber", unique = true, nullable = false)
    private String userMobile;

    @Column(name = "gender", nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "dateOfBirth")
    private LocalDate dateOfBirth;

    @Column(name = "address")
    private String address;

    @Column(name = "userType", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRole userRole;

//    @Column(name = "employeeId") // This can be foriengkey
//    private String employeeId;
//
//    @Column(name = "employeeDepartment") // This can be foriengkey
//    private String employeeDepartment;
}
