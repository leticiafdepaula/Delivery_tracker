package br.com.fooddelivery.delivery_tracker.controller;

import br.com.fooddelivery.delivery_tracker.dto.request.AtualizarStatusPedidoRequest;
import br.com.fooddelivery.delivery_tracker.dto.request.CriarPedidoRequest;
import br.com.fooddelivery.delivery_tracker.dto.response.PedidoResponse;
import br.com.fooddelivery.delivery_tracker.service.AtualizacaoStatusPedidoService;
import br.com.fooddelivery.delivery_tracker.service.PedidoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService pedidoService;
    private final AtualizacaoStatusPedidoService atualizacaoStatusService;

    @PostMapping
    public ResponseEntity<PedidoResponse> criar(
            @RequestBody @Valid CriarPedidoRequest request
    ){

        PedidoResponse response =
                pedidoService.criarPedido(request);


        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);

    }

    @GetMapping
    public ResponseEntity<List<PedidoResponse>> listar(){

        return ResponseEntity.ok(
                pedidoService.listar()
        );

    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoResponse> buscarPorId(
            @PathVariable Long id
    ){

        return ResponseEntity.ok(
                pedidoService.buscarPorId(id)
        );

    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<PedidoResponse> atualizarStatus(
            @PathVariable Long id,
            @RequestBody @Valid AtualizarStatusPedidoRequest request
    ){

        return ResponseEntity.ok(
                atualizacaoStatusService.atualizar(
                        id,
                        request
                )
        );

    }
}