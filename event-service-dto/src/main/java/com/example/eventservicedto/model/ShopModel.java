package com.example.eventservicedto.model;

import java.util.List;
import com.example.eventservicedto.entities.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ShopModel {

    private Long id;

    private String name;

    private String address;

    private List<VehicleModel> vehicles;

}
