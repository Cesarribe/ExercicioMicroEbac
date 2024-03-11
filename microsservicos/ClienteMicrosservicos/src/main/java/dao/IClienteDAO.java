package dao;

import domain.Cliente;

public interface IClienteDAO {
    Cliente cadastrarCliente(Cliente cliente);
    Cliente alterarCliente(Cliente cliente);
    Cliente pesquisarClientePorId(Long id);
    Cliente pesquisarClientePorCpf(String cpf);
}
