package br.com.alura.loja.testes;

import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class TestaProduto {
    public static void main(String[] args) {

        Produto celular = new Produto("iPhone 13", "Modinha", new BigDecimal("3700"), Categoria.CELULARES);

        EntityManager em = JPAUtil.getEntityManager();

        CategoriaDao categoriaDao = new CategoriaDao(em)
        ProdutoDao produtoDao = new ProdutoDao(em);

        em.getTransaction().begin();
        produtoDao.cadastrar(celular);
        em.getTransaction().commit();
        em.close();

    }
}