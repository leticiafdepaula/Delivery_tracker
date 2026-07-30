package br.com.fooddelivery.delivery_tracker.mapper;

import br.com.fooddelivery.delivery_tracker.domain.entity.Usuario;
import br.com.fooddelivery.delivery_tracker.dto.request.CadastroUsuarioRequest;
import br.com.fooddelivery.delivery_tracker.dto.response.UsuarioResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    Usuario toEntity(CadastroUsuarioRequest request);

    UsuarioResponse toResponse(Usuario usuario);
}