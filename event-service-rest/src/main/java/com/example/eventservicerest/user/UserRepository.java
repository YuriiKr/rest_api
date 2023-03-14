package com.example.eventservicerest.user;

import java.util.Optional;
import com.example.eventservicedto.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);

}
