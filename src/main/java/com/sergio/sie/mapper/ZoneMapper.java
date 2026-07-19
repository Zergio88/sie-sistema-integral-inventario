package com.sergio.sie.mapper;

import com.sergio.sie.dto.request.ZoneRequest;
import com.sergio.sie.dto.response.ZoneResponse;
import com.sergio.sie.entity.Zone;

public class ZoneMapper {

    public static Zone toEntity(ZoneRequest request) {
        Zone zone = new Zone();
        zone.setName(request.getName());
        zone.setDescription(request.getDescription());
        return zone;
    }

    public static ZoneResponse toResponse(Zone zone) {
        return new ZoneResponse(
                zone.getId(),
                zone.getName(),
                zone.getDescription()
        );
    }
}
