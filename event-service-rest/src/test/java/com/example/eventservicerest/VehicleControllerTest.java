package com.example.eventservicerest;

import java.util.ArrayList;
import java.util.List;
import com.example.eventservicedto.entities.Shop;
import com.example.eventservicedto.entities.Vehicle;
import com.example.eventservicedto.model.VehicleModel;
import static org.hamcrest.Matchers.containsString;
import com.example.eventservicerest.service.VehicleServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class VehicleControllerTest {

//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private VehicleServiceImpl vehicleServiceImpl;
//
//    @Test
//    void getAllVehiclesTest() throws Exception {
//
//        final VehicleModel vehicleModel = new VehicleModel();
//        final Vehicle vehicle = new Vehicle();
//        final Shop shop = new Shop();
//        shop.setId(1L);
//        shop.setAddress("Lviv");
//        shop.setName("RIK AUTO");
//        vehicleModel.setModel("BMW");
//        vehicleModel.setType("Car");
//        vehicleModel.setId(1L);
//        vehicleModel.setShopId(1L);
//        vehicle.setModel("BMW");
//        vehicle.setType("Car");
//        vehicle.setId(1L);
//        vehicle.setShop(shop);
//
//        List<Vehicle> listOfVehicleEntities = new ArrayList<>();
//        List<VehicleModel> listOfVehicleModels = new ArrayList<>();
//        listOfVehicleModels.add(vehicleModel);
//        listOfVehicleEntities.add(vehicle);
//
//        when(vehicleServiceImpl.getAllVehicles()).thenReturn(listOfVehicleModels);
//
//        this.mockMvc.perform(get("/vehicle/getAll")).andExpect(status().isOk())
//                .andExpect(content().string(containsString("BMW")));
//
//        verify(vehicleServiceImpl).getAllVehicles();
//    }
}
