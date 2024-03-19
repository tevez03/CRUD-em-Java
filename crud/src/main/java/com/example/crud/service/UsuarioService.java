package com.example.crud.service;

import com.example.crud.dto.UsuarioDTO;
import com.example.crud.entity.Permissao;
import com.example.crud.entity.Usuario;
import com.example.crud.exceptions.RegraNegocio;
import com.example.crud.repository.UsuarioRepository;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.crud.exceptions.RegraNegocio.*;

@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioDTO usuarioDTO;

    public Usuario adicionarUser(UsuarioDTO usuarioDTO) throws RegraNegocio {
        Usuario validandoCpf = usuarioRepository.findByCpf(this.usuarioDTO.getCpf());
        if (!isCPFValido(usuarioDTO.getCpf())) {
            throw new RegraNegocio(VALIDANDOCPF + usuarioDTO.getCpf());
        }

        if (validandoCpf != null) {
            throw new RegraNegocio(ERROCPF + usuarioDTO.getCpf());
        }

        Usuario validandoEmail = usuarioRepository.findByEmail(this.usuarioDTO.getEmail());
        if (validandoEmail != null) {
            throw new RegraNegocio(ERROEMAIL + usuarioDTO.getEmail());
        }

        Permissao permissao = new Permissao();
        permissao.setDescricao(ADMINISTRADOR);
        permissao.isAtivo(true);
        Permissao savePermissao = usuarioRepository.save(permissao);

        Usuario user = new Usuario();
        user.setNome(user.getNome());
        user.setCpf(user.getCpf());
        user.setEmail(user.getEmail());
        user.setIdade(user.getIdade());
        user.setDataCadastro(user.getDataCadastro());
        user.setPermissao(savePermissao);

        return usuarioRepository.save(user);
    }

    public List<Usuario> listarUser() throws RegraNegocio {
        List<Usuario> listar = usuarioRepository.findAll();
        return listar;
    }

    public Usuario buscarUser(Integer id) throws RegraNegocio {
        Optional<Usuario> buscar = usuarioRepository.findById(usuarioDTO.getId());
        if (buscar.isPresent()) {
            return buscar.get();
        } else {
            throw new RegraNegocio(IDNAOENCONTRADO + id);
        }
    }

    public void remover(Integer id) throws RegraNegocio {
        Optional<Usuario> removendo = usuarioRepository.findById(id);
        if (removendo.isPresent()) {
            usuarioRepository.delete(removendo.get());
        } else {
            throw new RegraNegocio(IDNAOENCONTRADO + id);
        }
    }

    private boolean isCPFValido(String cpf) {
        CPFValidator cpfValidator = new CPFValidator();
        return cpfValidator.isValid(cpf, null);
    }
}
