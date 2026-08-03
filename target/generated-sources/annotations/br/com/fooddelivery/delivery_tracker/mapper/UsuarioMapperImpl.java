package br.com.fooddelivery.delivery_tracker.mapper;

import br.com.fooddelivery.delivery_tracker.domain.entity.Usuario;
import br.com.fooddelivery.delivery_tracker.dto.request.CadastroUsuarioRequest;
import br.com.fooddelivery.delivery_tracker.dto.response.UsuarioResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-08-03T11:30:45-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.10 (Microsoft)"
)
@Component
public class UsuarioMapperImpl implements UsuarioMapper {

    @Override
    public Usuario toEntity(CadastroUsuarioRequest request) {
        if ( request == null ) {
            return null;
        }

        Usuario.UsuarioBuilder usuario = Usuario.builder();

        usuario.nome( request.nome() );
        usuario.email( request.email() );
        usuario.senha( request.senha() );

        return usuario.build();
    }

    @Override
    public UsuarioResponse toResponse(Usuario usuario) {
        if ( usuario == null ) {
            return null;
        }

        Long id = null;
        String nome = null;
        String email = null;

        id = usuario.getId();
        nome = usuario.getNome();
        email = usuario.getEmail();

        UsuarioResponse usuarioResponse = new UsuarioResponse( id, nome, email );

        return usuarioResponse;
    }
}
