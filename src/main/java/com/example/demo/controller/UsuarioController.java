package com.example.demo.controller;

import com.example.demo.model.LoginModel.LoginRequest;
import com.example.demo.model.LoginModel.LoginResponse;
import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/audote/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService servicoUsuario;

    @GetMapping
    public List<Usuario> obterTodos() {
        return servicoUsuario.obterTodos();
    }

    @GetMapping("/{id}")
    public Optional<Usuario> obterUsuarioPorId(@PathVariable("id") long id) {

        return servicoUsuario.obterPorId(id);
    }

    @GetMapping("/cidade")
    public List<Usuario> obterUsuarioPorCidade(@PathVariable("cidade") String cidade) {
        return servicoUsuario.obterUsuarioPorCidade(cidade);
    }

    @PostMapping("/cadastro")
    public Usuario adicionar(@RequestBody Usuario usuario) {
        return servicoUsuario.adicionar(usuario);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return servicoUsuario.logar(request.getEmail(), request.getSenha());
    }

    @DeleteMapping("/{id}")
    public void deletarUsuario(@PathVariable("id") long id) {
        servicoUsuario.deletarUsuario(id);
    }

}
