package com.example.eventservicerest.repository;

import com.example.eventservicedto.entities.Vehicle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    @Query(value = "SELECT * FROM vehicle where manufacturer = :manufacturer and model = :model ", nativeQuery = true)
    Page<Vehicle> getVehicleByName(String manufacturer, String model, Pageable page);

}
