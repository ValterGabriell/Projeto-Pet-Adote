package com.example.demo.service;


import com.example.demo.model.LoginModel.LoginResponse;
import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;
import com.example.demo.security.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private static final String hederPrefix = "Bearer ";
    @Autowired
    private UsuarioRepository repositorioUsuario;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JWTService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    public List<Usuario> obterTodos() {
        return repositorioUsuario.findAll();
    }

    public Optional<Usuario> obterPorId(long id) {
       return repositorioUsuario.findById(id);
    }

    public Optional<Usuario> obterPorEmail(String email) {
        return repositorioUsuario.findByEmail(email);
    }

    public Usuario adicionar(Usuario usuario) {
        usuario.setId(null);

        if (obterPorEmail(usuario.getEmail()).isPresent()) {
            throw new InputMismatchException("Já existe um usuario cadastro com o email: " + usuario.getEmail());
        }
        String senha = passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(senha);

        return repositorioUsuario.save(usuario);
    }

    public LoginResponse logar(String email, String senha) {
        Authentication autenticacao = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, senha, Collections.emptyList()));
        SecurityContextHolder.getContext().setAuthentication(autenticacao);
        String token = hederPrefix + jwtService.gerarToken(autenticacao);

        Usuario usuario = repositorioUsuario.findByEmail(email).get();

        return new LoginResponse(token, usuario);
    }

    public void deletarUsuario(Long id) {
        repositorioUsuario.deleteById(id);
    }

    public Usuario atualizarUsuario(Long id, Usuario usuario) {
        usuario.setId(id);
        repositorioUsuario.save(usuario);
        return usuario;
    }
}
