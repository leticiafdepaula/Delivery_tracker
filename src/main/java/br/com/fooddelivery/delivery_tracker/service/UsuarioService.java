package br.com.fooddelivery.delivery_tracker.service;

import br.com.fooddelivery.delivery_tracker.domain.entity.Usuario;
import br.com.fooddelivery.delivery_tracker.dto.request.CadastroUsuarioRequest;
import br.com.fooddelivery.delivery_tracker.dto.response.UsuarioResponse;
import br.com.fooddelivery.delivery_tracker.exception.RegraNegocioException;
import br.com.fooddelivery.delivery_tracker.mapper.UsuarioMapper;
import br.com.fooddelivery.delivery_tracker.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;
    private final PasswordEncoder passwordEncoder;


    public UsuarioResponse cadastrar(
            CadastroUsuarioRequest request
    ){

        if(usuarioRepository.existsByEmail(request.email())){
            throw new RegraNegocioException(
                    "Email já cadastrado"
            );
        }

        Usuario usuario =
                usuarioMapper.toEntity(request);

        usuario.setSenha(
                passwordEncoder.encode(request.senha())
        );


        Usuario salvo =
                usuarioRepository.save(usuario);
        return usuarioMapper.toResponse(salvo);

    }
}