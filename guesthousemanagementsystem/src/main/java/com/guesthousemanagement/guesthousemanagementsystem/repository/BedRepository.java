package com.guesthousemanagement.guesthousemanagementsystem.repository;

import com.guesthousemanagement.guesthousemanagementsystem.entity.guesthouse.Bed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BedRepository extends JpaRepository<Bed,Long> {
}
