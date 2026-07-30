package br.com.fooddelivery.delivery_tracker.controller;

import br.com.fooddelivery.delivery_tracker.dto.request.CadastroUsuarioRequest;
import br.com.fooddelivery.delivery_tracker.dto.response.UsuarioResponse;
import br.com.fooddelivery.delivery_tracker.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {


    private final UsuarioService usuarioService;


    @PostMapping
    public ResponseEntity<UsuarioResponse> cadastrar(
            @RequestBody @Valid CadastroUsuarioRequest request
    ){

        UsuarioResponse response =
                usuarioService.cadastrar(request);


        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

}