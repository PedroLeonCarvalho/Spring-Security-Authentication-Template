package com.barbearia_ibertioga.barbearia_api.repository;

import com.barbearia_ibertioga.barbearia_api.domain.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrivilegeRepository extends JpaRepository <Privilege, Long> {
    Privilege findByName(String name);
}
