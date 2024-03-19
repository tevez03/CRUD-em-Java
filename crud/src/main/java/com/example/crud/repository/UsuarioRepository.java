package com.example.crud.repository;

import com.example.crud.entity.Permissao;
import com.example.crud.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Usuario findByCpf(String cpf);

    Usuario findByEmail(String cpf);

    Permissao save(Permissao usuario);
}
