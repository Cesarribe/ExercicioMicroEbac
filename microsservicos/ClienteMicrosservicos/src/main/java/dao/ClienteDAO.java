package dao;

import domain.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@Repository
public class ClienteDAO implements IClienteDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Cliente cadastrarCliente(Cliente cliente) {
        entityManager.persist(cliente);
        return cliente;
    }

    @Override
    public Cliente alterarCliente(Cliente cliente) {
        return entityManager.merge(cliente);
    }

    @Override
    public Cliente pesquisarClientePorId(Long id) {
        return entityManager.find(Cliente.class, id);
    }

    @Override
    public Cliente pesquisarClientePorCpf(String cpf) {
        TypedQuery<Cliente> query = entityManager.createQuery(
                "SELECT c FROM Cliente c WHERE c.cpf = :cpf", Cliente.class);
        query.setParameter("cpf", cpf);
        return query.getSingleResult();
    }
}