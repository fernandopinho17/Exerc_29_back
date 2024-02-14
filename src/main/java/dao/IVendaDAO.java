package pt.com.ferpinho.dao;

import pt.com.ferpinho.dao.generic.IGenericDAO;
import pt.com.ferpinho.domain.Venda;
import pt.com.ferpinho.exceptions.TipoChaveNaoEncontradaException;


public interface IVendaDAO extends IGenericDAO<Venda, String> {

    public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException;
}
