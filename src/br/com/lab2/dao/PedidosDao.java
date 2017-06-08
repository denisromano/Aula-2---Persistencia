package br.com.lab2.dao;

import java.util.List;

import br.com.lab2.entity.Pedidos;

public interface PedidosDao {
	void incluirPedido(Pedidos pedido) throws Exception;
	List<Pedidos> listarPedidos(int idCliente) throws Exception;

}
