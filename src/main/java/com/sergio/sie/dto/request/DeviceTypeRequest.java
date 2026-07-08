package com.sergio.sie.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public class DeviceTypeRequest {

    @NotBlank
    @Size(max = 100, message = "Name must not exceed 100 characters")
   private String name;

    @Size(max = 100, message = "Brand must not exceed 100 characters")
    private String brand;

    @Size(max = 100, message = "Model must not exceed 100 characters")
    private String model;

    @NotBlank
    @Size(max = 50, message = "Category must not exceed 50 characters")
    private String category;

    private String description;

    public DeviceTypeRequest() { }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

