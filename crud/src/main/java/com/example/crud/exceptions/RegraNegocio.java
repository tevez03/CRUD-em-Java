package com.example.crud.exceptions;

public class RegraNegocio extends RuntimeException {

    public static final String ERROCPF = "O usuario ja existe. CPF ja foi cadastrado: ";
    public static final String ERROEMAIL = "O usuario ja existe. E-mail ja foi cadastrado: ";
    public static final String IDNAOENCONTRADO = "Usuário não encontrado com o ID: ";
    public static final String VALIDANDOCPF = "CPF inválido: ";
    public static final String ADMINISTRADOR = "Administrador";

    public RegraNegocio(String mensagem) {
        super(mensagem);
    }
}
