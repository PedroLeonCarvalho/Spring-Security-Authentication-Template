package com.barbearia_ibertioga.barbearia_api.repository;

import com.barbearia_ibertioga.barbearia_api.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository <Role, Long> {
    Role findByName(String role);

    ;
}
