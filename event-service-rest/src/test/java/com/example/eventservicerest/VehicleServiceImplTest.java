package com.example.eventservicerest;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import com.example.eventservicedto.entities.Event;
import com.example.eventservicedto.entities.Shop;
import com.example.eventservicedto.entities.Vehicle;
import com.example.eventservicedto.model.VehicleModel;
import com.example.eventserviceimpl.service.EventServiceImpl;
import com.example.eventservicerest.repository.JPAEventStorage;
import com.example.eventservicerest.repository.ShopRepository;
import com.example.eventservicerest.repository.VehicleRepository;
import com.example.eventservicerest.service.VehicleServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.convert.converter.Converter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class VehicleServiceImplTest {

    @Mock
    private VehicleRepository vehicleRepository;

    @Mock
    private ShopRepository shopRepository;

    @Mock
    private Converter<Vehicle, VehicleModel> vehicleEntityToModelConverter;

    @Mock
    private Converter<VehicleModel, Vehicle> vehicleModelToEntityConverter;

    private VehicleServiceImpl vehicleServiceImpl;

    @BeforeEach
    void setUp() {
        this.vehicleServiceImpl = new VehicleServiceImpl(vehicleRepository, shopRepository,
                vehicleEntityToModelConverter, vehicleModelToEntityConverter);
    }

    @Test
    void getAllVehiclesTest() {

        final VehicleModel vehicleModel = new VehicleModel();
        final Vehicle vehicle = new Vehicle();
        final Shop shop = new Shop();
        shop.setId(1L);
        shop.setAddress("Lviv");
        shop.setName("RIK AUTO");
        vehicleModel.setModel("BMW");
        vehicleModel.setType("Car");
        vehicleModel.setId(1L);
        vehicleModel.setShopId(1L);
        vehicle.setModel("BMW");
        vehicle.setType("Car");
        vehicle.setId(1L);
        vehicle.setShop(shop);

        List<Vehicle> listOfVehicleEntities = new ArrayList<>();
        List<VehicleModel> listOfVehicleModels = new ArrayList<>();
        listOfVehicleModels.add(vehicleModel);
        listOfVehicleEntities.add(vehicle);

        when(vehicleRepository.findAll()).thenReturn(listOfVehicleEntities);
        when(vehicleEntityToModelConverter.convert(vehicle)).thenReturn(vehicleModel);
        List<VehicleModel> result = vehicleServiceImpl.getAllVehicles();

        assertEquals("BMW", result.get(0).getModel());

        verify(vehicleRepository).findAll();
        verify(vehicleEntityToModelConverter).convert(vehicle);
    }
}
