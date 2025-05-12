package com.guesthousemanagement.guesthousemanagementsystem.repository;

import com.guesthousemanagement.guesthousemanagementsystem.entity.guesthouse.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
