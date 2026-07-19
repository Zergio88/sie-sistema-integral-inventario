package com.sergio.sie.dto.response;

public class LocationResponse {

    private Integer id;
    private Integer zoneId;
    private String zoneName;
    private String name;
    private String locationType;
    private String notes;

    public LocationResponse() { }

    public LocationResponse(Integer id, Integer zoneId, String zoneName, String name, String locationType, String notes) {
        this.id = id;
        this.zoneId = zoneId;
        this.zoneName = zoneName;
        this.name = name;
        this.locationType = locationType;
        this.notes = notes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getZoneId() {
        return zoneId;
    }

    public void setZoneId(Integer zoneId) {
        this.zoneId = zoneId;
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
