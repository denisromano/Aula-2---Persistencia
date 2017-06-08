package br.com.lab2.application;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.lab2.dao.ClientesDao;
import br.com.lab2.dao.DaoFactory;
import br.com.lab2.dao.PedidosDao;
import br.com.lab2.entity.Clientes;
import br.com.lab2.entity.Pedidos;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			ClientesDao clientesDao = DaoFactory.getDaoFactory(DaoFactory.MYSQL).getClientesDao();
			
			List<Pedidos> listaPedidos = new ArrayList<>();
			
			Clientes cliente = new Clientes();
			cliente.setNome("Pedro Fontes");
			cliente.setEmail("pedro@fontes.com");			
			cliente = clientesDao.inserirCliente(cliente);
						
			PedidosDao pedidosDao = DaoFactory.getDaoFactory(DaoFactory.MYSQL).getPedidosDao();
			
			
			Pedidos pedido = new Pedidos();
			pedido.setData(new Date());
			pedido.setDescricao("Materiais Escritório");
			pedido.setValor(9000);
			pedido.setIdCliente(cliente.getId());
			
			pedidosDao.incluirPedido(pedido);
			
			listaPedidos = pedidosDao.listarPedidos(7);
			for (Pedidos pedidos : listaPedidos) {
				System.out.println(pedidos.getDescricao());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
