package com.barbearia_ibertioga.barbearia_api.Controller;

import com.barbearia_ibertioga.barbearia_api.DTO.LoginDTO;
import com.barbearia_ibertioga.barbearia_api.domain.User;
import com.barbearia_ibertioga.barbearia_api.infra.Security.TokenDTO;
import com.barbearia_ibertioga.barbearia_api.infra.Security.TokenService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/login")

public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;


    public AuthenticationController(AuthenticationManager authenticationManager, TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;

    }

    @PostMapping

    public ResponseEntity login(@RequestBody LoginDTO dto) {

        var token = new UsernamePasswordAuthenticationToken(dto.email(), dto.password());
        var authentication = authenticationManager.authenticate(token);
        var tokenJWT = tokenService.tokenGenerate((User) authentication.getPrincipal());

        return ResponseEntity.ok(new TokenDTO(tokenJWT));
    }

    @PostMapping("/refresh")

    public ResponseEntity<TokenDTO> refreshToken(@RequestBody String tokenJWT) {

        var newTokenJWT = tokenService.refreshToken(tokenJWT);
        return ResponseEntity.ok(new TokenDTO(newTokenJWT));
    }


}