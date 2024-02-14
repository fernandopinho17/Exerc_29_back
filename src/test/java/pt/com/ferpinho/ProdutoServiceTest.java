package br.com.rpires;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import pt.com.ferpinho.dao.IProdutoDAO;
import pt.com.ferpinho.dao.ProdutoDaoMock;
import pt.com.ferpinho.domain.Produto;
import pt.com.ferpinho.exceptions.TipoChaveNaoEncontradaException;
import pt.com.ferpinho.services.IProdutoService;
import pt.com.ferpinho.services.ProdutoService;


public class ProdutoServiceTest {

    private IProdutoService produtoService;

    private Produto produto;

    public ProdutoServiceTest() {
        IProdutoDAO dao = new ProdutoDaoMock();
        produtoService = new ProdutoService(dao);
    }

    @Before
    public void init() {
        produto = new Produto();
        produto.setCodigo("A1");
        produto.setDescricao("Produto 1");
        produto.setNome("Produto 1");
        produto.setValor(BigDecimal.TEN);
    }

    @Test
    public void pesquisar() {
        Produto produtor = this.produtoService.consultar(produto.getCodigo());
        Assert.assertNotNull(produtor);
    }

    @Test
    public void salvar() throws TipoChaveNaoEncontradaException {
        Boolean retorno = produtoService.cadastrar(produto);
        Assert.assertTrue(retorno);
    }

    @Test
    public void excluir() {
        produtoService.excluir(produto.getCodigo());
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException {
        produto.setNome("Fernando Pinho");
        produtoService.alterar(produto);

        Assert.assertEquals("Fernando Pinho", produto.getNome());
    }
}