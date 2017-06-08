package br.com.lab2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.lab2.entity.Clientes;

public class MySQLClientesDao implements ClientesDao {
	Connection cn = null;
	PreparedStatement stmt;
	ResultSet rs = null;

	@Override
	public Clientes inserirCliente(Clientes cliente) throws Exception {
		try {
			cn = MySQLDaoFactory.criarConexao();
			stmt = cn.prepareStatement("INSERT INTO CLIENTES (ID,NOME, EMAIL) VALUES (?,?,?)");
			stmt.setInt(1, cliente.getId());
			stmt.setString(2, cliente.getNome());
			stmt.setString(3, cliente.getEmail());
			stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			cn.close();
		}
		return cliente;
	}

	@Override
	public Clientes buscarCliente(int id) {
		return null;
	}
}
