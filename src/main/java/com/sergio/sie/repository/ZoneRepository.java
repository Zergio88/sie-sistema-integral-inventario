package com.sergio.sie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sergio.sie.entity.Zone;

public interface ZoneRepository extends JpaRepository<Zone, Integer> {
}
