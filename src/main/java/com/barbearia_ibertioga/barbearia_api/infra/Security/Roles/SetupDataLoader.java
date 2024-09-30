package com.barbearia_ibertioga.barbearia_api.infra.Security.Roles;

import com.barbearia_ibertioga.barbearia_api.domain.Privilege;
import com.barbearia_ibertioga.barbearia_api.domain.Role;
import com.barbearia_ibertioga.barbearia_api.domain.User;
import com.barbearia_ibertioga.barbearia_api.repository.PrivilegeRepository;
import com.barbearia_ibertioga.barbearia_api.repository.RoleRepository;
import com.barbearia_ibertioga.barbearia_api.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {


        boolean alreadySetup = false;

        @Autowired
        private UserRepository userRepository;

        @Autowired
        private RoleRepository roleRepository;

        @Autowired
        private PrivilegeRepository privilegeRepository;

        @Autowired
        private PasswordEncoder passwordEncoder;

        @Override
        @Transactional
        public void onApplicationEvent (ContextRefreshedEvent event){

        if (alreadySetup)
            return;
        Privilege readPrivilege
                = createPrivilegeIfNotFound("READ_PRIVILEGE");
        Privilege writePrivilege
                = createPrivilegeIfNotFound("WRITE_PRIVILEGE");

        List<Privilege> adminPrivileges = Arrays.asList(
                readPrivilege, writePrivilege);
        createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);
        createRoleIfNotFound("ROLE_USER", Arrays.asList(readPrivilege));

        Role adminRole = roleRepository.findByName("ROLE_ADMIN");
        User user = new User();
        user.setName("User Name John");
        user.setEmail("usernamejohn@email.com");
        user.setPassword(passwordEncoder.encode("barbearia"));
        user.setRoles(Arrays.asList(adminRole));
        user.setEnabled(true);
        userRepository.save(user);

        alreadySetup = true;
     }

        @Transactional
        Privilege createPrivilegeIfNotFound (String name){

        Privilege privilege = privilegeRepository.findByName(name);
        if (privilege == null) {
            privilege = new Privilege(name);
            privilegeRepository.save(privilege);
        }
        return privilege;
    }

        @Transactional
        Role createRoleIfNotFound (
            String name, Collection< Privilege > privileges){

        Role role = roleRepository.findByName(name);
        if (role == null) {
            role = new Role(name);
            role.setPrivileges(privileges);
            roleRepository.save(role);
        }
        return role;
    }
    }
