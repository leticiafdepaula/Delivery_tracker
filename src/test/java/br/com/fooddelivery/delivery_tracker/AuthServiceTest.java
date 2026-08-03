package br.com.fooddelivery.delivery_tracker.service;

import br.com.fooddelivery.delivery_tracker.dto.request.LoginRequest;
import br.com.fooddelivery.delivery_tracker.dto.response.LoginResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AuthServiceTest {

    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private JwtService jwtService;

    @InjectMocks
    private AuthService authService;

    @Test
    void deveRealizarLoginComSucesso() {

        LoginRequest request =
                new LoginRequest(
                        "leticia@email.com",
                        "123456"
                );

        when(jwtService.gerarToken(request.email()))
                .thenReturn("jwt-token-teste");

        LoginResponse response =
                authService.login(request);

        assertNotNull(response);
        assertEquals(
                "jwt-token-teste",
                response.token()
        );

        verify(authenticationManager)
                .authenticate(any(UsernamePasswordAuthenticationToken.class));

        verify(jwtService)
                .gerarToken(request.email());
    }
}