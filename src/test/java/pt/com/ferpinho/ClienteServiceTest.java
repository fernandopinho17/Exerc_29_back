package pt.com.ferpinho;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import pt.com.ferpinho.dao.ClienteDaoMock;
import pt.com.ferpinho.dao.IClienteDAO;
import pt.com.ferpinho.domain.Cliente;
import pt.com.ferpinho.exceptions.TipoChaveNaoEncontradaException;
import pt.com.ferpinho.services.ClienteService;
import pt.com.ferpinho.services.IClienteService;

public class ClienteServiceTest {

    private IClienteService clienteService;

    private Cliente cliente;

    public ClienteServiceTest() {
        IClienteDAO dao = new ClienteDaoMock();
        clienteService = new ClienteService(dao);
    }

    @Before
    public void init() {
        cliente = new Cliente();
        cliente.setCpf(12312312312L);
        cliente.setNome("Frnando");
        cliente.setCidade("Luanda");
        cliente.setEnd("End");
        cliente.setEstado("LD");
        cliente.setNumero(10);
        cliente.setTel(1199999999L);

    }

    @Test
    public void pesquisarCliente() {
        Cliente clienteConsultado = clienteService.buscarPorCPF(cliente.getCpf());
        Assert.assertNotNull(clienteConsultado);
    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException {
        Boolean retorno = clienteService.cadastrar(cliente);

        Assert.assertTrue(retorno);
    }

    @Test
    public void excluirCliente() {
        clienteService.excluir(cliente.getCpf());
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException {
        cliente.setNome("Fernando Pinho");
        clienteService.alterar(cliente);

        Assert.assertEquals("Fernando Pinho", cliente.getNome());
    }
}
