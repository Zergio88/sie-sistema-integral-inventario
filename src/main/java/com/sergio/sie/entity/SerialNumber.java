package com.sergio.sie.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "serial_number")
public class SerialNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "device_id", nullable = false)
    private Device device;

    @Column(name = "value", nullable = false, length = 100)
    private String value;

    @Column(name = "source", nullable = false, length = 50)
    private String source;

    @Column(name = "is_primary", nullable = false)
    private Boolean primary;

    public SerialNumber() { }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
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
