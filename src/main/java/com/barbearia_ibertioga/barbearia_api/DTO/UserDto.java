package com.barbearia_ibertioga.barbearia_api.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.time.LocalDate;

public record UserDto (

     String name,
     String email,
     String phoneNumber,
     LocalDate birthDate,
     String password

)  implements Serializable { }
