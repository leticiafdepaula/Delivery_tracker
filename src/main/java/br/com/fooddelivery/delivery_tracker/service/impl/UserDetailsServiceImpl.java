package br.com.fooddelivery.delivery_tracker.service.impl;

import br.com.fooddelivery.delivery_tracker.domain.entity.Usuario;
import br.com.fooddelivery.delivery_tracker.repository.UsuarioRepository;
import br.com.fooddelivery.delivery_tracker.security.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {

        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                "Usuário não encontrado"
                        ));

        return new CustomUserDetails(usuario);
    }
}