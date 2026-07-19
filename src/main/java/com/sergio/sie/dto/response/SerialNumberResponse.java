package com.sergio.sie.dto.response;

public class SerialNumberResponse {

    private Integer id;
    private Integer deviceId;
    private String value;
    private String source;
    private Boolean primary;

    public SerialNumberResponse() { }

    public SerialNumberResponse(Integer id, Integer deviceId, String value, String source, Boolean primary) {
        this.id = id;
        this.deviceId = deviceId;
        this.value = value;
        this.source = source;
        this.primary = primary;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDeviceId() {
        return deviceId;
    }
    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }

    public String getSource() {
        return source;
    }
    public void setSource(String source) {
        this.source = source;
    }

    public Boolean getPrimary() {
        return primary;
    }
    public void setPrimary(Boolean primary) {
        this.primary = primary;
    }
}
