package com.example.eventservicerest.repository;

import java.util.Optional;
import com.example.eventservicerest.entities.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {

    @Query(value = "SELECT * FROM shop WHERE \"shopId\" = 1", nativeQuery = true)
    Optional<Shop> findByShopId(Long shopId);
}
