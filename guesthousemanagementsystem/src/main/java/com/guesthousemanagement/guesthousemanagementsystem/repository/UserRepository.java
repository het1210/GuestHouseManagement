package com.guesthousemanagement.guesthousemanagementsystem.repository;

import com.guesthousemanagement.guesthousemanagementsystem.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String userName);
    User findByUserEmail(String email);
}
