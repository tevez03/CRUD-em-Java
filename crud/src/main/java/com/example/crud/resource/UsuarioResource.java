package com.example.crud.resource;

import com.example.crud.dto.UsuarioDTO;
import com.example.crud.entity.Usuario;
import com.example.crud.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioResource {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> adicionarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        Usuario salvar = usuarioService.adicionarUser(usuarioDTO);
        return new ResponseEntity<>(salvar, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarUsuario(@PathVariable Integer id) {
        Usuario buscar = usuarioService.buscarUser(id);
        return ResponseEntity.ok(buscar);
    }

    @GetMapping("/listar")
    public List<Usuario> listarUsuarios() {
        List<Usuario> usuarios = usuarioService.listarUser();
        return usuarios;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Integer id) {
        usuarioService.remover(id);
        return ResponseEntity.ok().build();
    }
}
