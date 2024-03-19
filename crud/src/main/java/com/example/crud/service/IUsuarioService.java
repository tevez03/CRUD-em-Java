package com.example.crud.service;

import com.example.crud.dto.UsuarioDTO;
import com.example.crud.entity.Usuario;
import com.example.crud.exceptions.RegraNegocio;

import java.util.List;

public interface IUsuarioService {

    Usuario adicionarUser(UsuarioDTO usuarioDTO) throws RegraNegocio;

    Usuario buscarUser(Integer id) throws RegraNegocio;
    
    List<Usuario> listarUser() throws RegraNegocio;

    void remover(Integer id) throws RegraNegocio;
}
