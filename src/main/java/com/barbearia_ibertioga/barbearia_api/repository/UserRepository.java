package com.barbearia_ibertioga.barbearia_api.repository;

import com.barbearia_ibertioga.barbearia_api.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository <User, Long> {

    User findByEmail(String email);

    User findByPhoneNumber(String phoneNumber);
}
