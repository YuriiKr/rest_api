package com.example.eventservicerest.repository;

import com.example.eventservicerest.user.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserProfile,Long> {
}
