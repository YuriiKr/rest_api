package com.example.eventservicedto.model;

import com.example.eventservicedto.entities.Shop;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VehicleModel {

    private Long id;
    private String type;
    private String model;
    private Long shopId;

}
