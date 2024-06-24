package br.com.alura.loja.testes;

import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class TestaProduto {
    public static void main(String[] args) {
        cadastrarProduto();
        Long id = 1l;
        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);

        Produto p = produtoDao.buscarProduto(1l);
        System.out.println(p.getPreco());

        List<Produto> todos = produtoDao.buscarPorNomeDaCategoria("CELULARES");
        todos.forEach(p3 -> System.out.println(p3.getNome()));

        BigDecimal p2 = produtoDao.buscarPrecoDoProdutoPorNome("Galaxy S23");
        System.out.println(p2);
    }

    private static void cadastrarProduto() {
//        Categoria celurares = new Categoria("CELULARES");
//        Produto celular = new Produto("iPhone 15 Pro Max", "O mais caro de todos", new BigDecimal("6700"), celurares);

        EntityManager em = JPAUtil.getEntityManager();

        CategoriaDao categoriaDao = new CategoriaDao(em);
        ProdutoDao produtoDao = new ProdutoDao(em);

        em.getTransaction().begin();
//
//        categoriaDao.cadastrar(celurares);
//        produtoDao.cadastrar(celular);

        em.getTransaction().commit();
        em.close();
    }
}