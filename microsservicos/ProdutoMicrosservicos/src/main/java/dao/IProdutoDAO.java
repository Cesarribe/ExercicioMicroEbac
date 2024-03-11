package dao;


import domain.Produto;

public interface IProdutoDAO {
    Produto cadastrarProduto(Produto produto);
    Produto alterarProduto(Produto produto);
    Produto pesquisarProdutoPorId(Long id);
}

