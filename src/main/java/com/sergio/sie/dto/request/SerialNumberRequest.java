package com.sergio.sie.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class SerialNumberRequest {

    @NotNull(message = "Device ID is required")
    private Integer deviceId;

    @NotBlank(message = "Serial number value is required")
    @Size(max = 100, message = "Serial number value must not exceed 100 characters")
    private String value;

    @NotBlank(message = "Source is required")
    @Size(max = 50, message = "Source must not exceed 50 characters")
    private String source;

    @NotNull(message = "Primary flag is required")
    private Boolean primary;

    public SerialNumberRequest() { }

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

    public Boolean isPrimary() {
        return primary;
    }

    public void setPrimary(Boolean primary) {
        this.primary = primary;
    }
}
