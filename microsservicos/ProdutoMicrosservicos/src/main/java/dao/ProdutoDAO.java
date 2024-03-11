package dao;

import domain.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class ProdutoDAO implements IProdutoDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Produto cadastrarProduto(Produto produto) {
        entityManager.persist(produto);
        return produto;
    }

    @Override
    public Produto alterarProduto(Produto produto) {
        return entityManager.merge(produto);
    }

    @Override
    public Produto pesquisarProdutoPorId(Long id) {
        return entityManager.find(Produto.class, id);
    }
}