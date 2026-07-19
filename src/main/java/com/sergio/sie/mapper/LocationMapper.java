package com.sergio.sie.mapper;

import com.sergio.sie.dto.request.LocationRequest;
import com.sergio.sie.dto.response.LocationResponse;
import com.sergio.sie.entity.Location;
import com.sergio.sie.entity.Zone;

public class LocationMapper {

    public static Location toEntity(LocationRequest request, Zone zone) {
        Location location = new Location();
        location.setZone(zone);
        location.setName(request.getName());
        location.setLocationType(request.getLocationType());
        location.setNotes(request.getNotes());
        return location;
    }

    public static LocationResponse toResponse(Location location) {
        Zone zone = location.getZone();
        return new LocationResponse(
                location.getId(),
                zone != null ? zone.getId() : null,
                zone != null ? zone.getName() : null,
                location.getName(),
                location.getLocationType(),
                location.getNotes()
        );
    }
}
