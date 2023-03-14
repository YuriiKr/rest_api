package com.example.eventservicedto.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public record ShopModel(Long id, String name, String address, List<VehicleModel> vehicle) {

}
