package com.example.eventservicedto.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VehicleModel {

    private Long id;
    private String type;
    private String model;
    private String manufacturer;
    private Long shopId;

    public VehicleModel() {

    }
}
