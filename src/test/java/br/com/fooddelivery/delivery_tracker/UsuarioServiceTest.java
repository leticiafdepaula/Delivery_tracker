package br.com.fooddelivery.delivery_tracker;

import br.com.fooddelivery.delivery_tracker.domain.entity.Usuario;
import br.com.fooddelivery.delivery_tracker.dto.request.CadastroUsuarioRequest;
import br.com.fooddelivery.delivery_tracker.dto.response.UsuarioResponse;
import br.com.fooddelivery.delivery_tracker.exception.RegraNegocioException;
import br.com.fooddelivery.delivery_tracker.mapper.UsuarioMapper;
import br.com.fooddelivery.delivery_tracker.repository.UsuarioRepository;
import br.com.fooddelivery.delivery_tracker.service.UsuarioService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UsuarioServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private UsuarioMapper usuarioMapper;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UsuarioService usuarioService;

    @Test
    void deveCadastrarUsuarioComSucesso() {

        CadastroUsuarioRequest request =
                new CadastroUsuarioRequest(
                        "Leticia",
                        "leticia@email.com",
                        "123456"
                );

        Usuario usuario = new Usuario();
        usuario.setNome("Leticia");
        usuario.setEmail("leticia@email.com");
        usuario.setSenha("123456");

        Usuario usuarioSalvo = new Usuario();
        usuarioSalvo.setId(1L);
        usuarioSalvo.setNome("Leticia");
        usuarioSalvo.setEmail("leticia@email.com");
        usuarioSalvo.setSenha("senhaCriptografada");

        UsuarioResponse response =
                new UsuarioResponse(
                        1L,
                        "Leticia",
                        "leticia@email.com"
                );

        when(usuarioRepository.existsByEmail(request.email()))
                .thenReturn(false);

        when(usuarioMapper.toEntity(request))
                .thenReturn(usuario);

        when(passwordEncoder.encode(request.senha()))
                .thenReturn("senhaCriptografada");

        when(usuarioRepository.save(usuario))
                .thenReturn(usuarioSalvo);

        when(usuarioMapper.toResponse(usuarioSalvo))
                .thenReturn(response);

        UsuarioResponse resultado =
                usuarioService.cadastrar(request);

        assertNotNull(resultado);
        assertEquals(1L, resultado.id());
        assertEquals("Leticia", resultado.nome());
        assertEquals("leticia@email.com", resultado.email());

        verify(usuarioRepository).save(usuario);
    }

    @Test
    void deveLancarExcecaoQuandoEmailJaExistir() {

        CadastroUsuarioRequest request =
                new CadastroUsuarioRequest(
                        "Leticia",
                        "leticia@email.com",
                        "123456"
                );

        when(usuarioRepository.existsByEmail(request.email()))
                .thenReturn(true);

        RegraNegocioException exception =
                assertThrows(
                        RegraNegocioException.class,
                        () -> usuarioService.cadastrar(request)
                );

        assertEquals(
                "Email já cadastrado",
                exception.getMessage()
        );

        verify(usuarioRepository, never()).save(any());
    }
}