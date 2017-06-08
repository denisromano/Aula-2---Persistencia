package br.com.lab2.dao;

import br.com.lab2.entity.Clientes;

public interface ClientesDao {
	Clientes inserirCliente(Clientes cliente) throws Exception;
	Clientes buscarCliente(int id) throws Exception;
}
