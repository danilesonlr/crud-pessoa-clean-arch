package br.com.pessoa.controller;

import br.com.pessoa.dto.RegisterDTO;
import br.com.pessoa.dto.ResponseAuthenticationToken;
import br.com.pessoa.auth.service.AuthenticationSecurityServiceImpl;
import br.com.pessoa.dto.AuthenticationDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationSecurityServiceImpl authenticationSecurityService;


    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO authenticationDTO){
        String token = authenticationSecurityService.authentication(authenticationDTO.getLogin(),
                authenticationDTO.getSenha());
        return ResponseEntity.ok(ResponseAuthenticationToken.builder()
                .token(token)
                .build());
    }

    @PostMapping("/register")
    public ResponseEntity login(@RequestBody @Valid RegisterDTO registerDTO){
        authenticationSecurityService.register(registerDTO.getLogin(), registerDTO.getSenha(),
                registerDTO.getRole().name());
        return ResponseEntity.ok().build();
    }
}
