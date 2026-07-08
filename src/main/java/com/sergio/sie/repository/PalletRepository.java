package com.sergio.sie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sergio.sie.entity.Pallet;

public interface PalletRepository extends JpaRepository<Pallet, Integer> {
}
