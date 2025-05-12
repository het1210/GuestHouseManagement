package com.guesthousemanagement.guesthousemanagementsystem.repository;

import com.guesthousemanagement.guesthousemanagementsystem.entity.guesthouse.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room,Long> {
}
