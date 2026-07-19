package com.sergio.sie.mapper;

import com.sergio.sie.dto.request.PalletRequest;
import com.sergio.sie.dto.response.PalletResponse;
import com.sergio.sie.entity.Location;
import com.sergio.sie.entity.Pallet;

import java.time.LocalDateTime;

public class PalletMapper {

    public static Pallet toEntity(PalletRequest request, Location location){
        Pallet pallet = new Pallet();
        pallet.setLocation(location);
        pallet.setCode(request.getCode());
        pallet.setMaxFloors(request.getMaxFloors());
        pallet.setNotes(request.getNotes());
        pallet.setCreatedAt(LocalDateTime.now());
        pallet.setUpdatedAt(LocalDateTime.now());
        return pallet;
    }

    public static PalletResponse toResponse(Pallet pallet){
        Location location = pallet.getLocation();
        return new PalletResponse(
                pallet.getId(),
                location != null ? location.getId() : null,
                location != null ? location.getName() : null,
                pallet.getCode(),
                pallet.getMaxFloors(),
                pallet.getNotes(),
                pallet.getCreatedAt(),
                pallet.getUpdatedAt()
        );
    }
}
