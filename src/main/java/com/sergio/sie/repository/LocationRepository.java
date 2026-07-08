package com.sergio.sie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sergio.sie.entity.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {
}
