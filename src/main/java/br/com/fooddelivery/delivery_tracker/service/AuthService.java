package br.com.fooddelivery.delivery_tracker.service;

import br.com.fooddelivery.delivery_tracker.dto.request.LoginRequest;
import br.com.fooddelivery.delivery_tracker.dto.response.LoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public LoginResponse login(LoginRequest request){

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.senha()
                )
        );

        String token = jwtService.gerarToken(request.email());

        return new LoginResponse(token);
    }

}