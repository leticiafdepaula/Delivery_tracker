package br.com.fooddelivery.delivery_tracker.controller;

import br.com.fooddelivery.delivery_tracker.dto.request.CadastroUsuarioRequest;
import br.com.fooddelivery.delivery_tracker.dto.request.LoginRequest;
import br.com.fooddelivery.delivery_tracker.dto.response.LoginResponse;
import br.com.fooddelivery.delivery_tracker.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(
            @RequestBody @Valid LoginRequest request) {

        return ResponseEntity.ok(
                authService.login(request)
        );
    }

    @PostMapping("/cadastro")
    public ResponseEntity<String> cadastrar(
            @RequestBody @Valid CadastroUsuarioRequest request) {

        authService.cadastrar(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Usuário cadastrado com sucesso.");
    }

}