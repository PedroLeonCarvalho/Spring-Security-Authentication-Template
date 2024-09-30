package com.barbearia_ibertioga.barbearia_api.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name ="privileges")
public class Privilege {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy ="privileges")
    private Collection<Role> roles;

    public Privilege(String name) {
        this.name = name;
    }
}