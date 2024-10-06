package com.barbearia_ibertioga.barbearia_api.DTO;

import java.io.Serializable;

public record LoginDTO(
        String email,
        String password
) implements Serializable {


}