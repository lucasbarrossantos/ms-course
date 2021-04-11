package com.devsuperior.hrworker.servicies.exception;

public class WorkerNotFoundException extends EntidadeNaoEncontradaException {

    public WorkerNotFoundException(String mensagem) {
        super(mensagem);
    }

    public WorkerNotFoundException(Long id) {
        this(String.format("Não existe um worker com o id: %s na base de dados!", id));
    }

}
