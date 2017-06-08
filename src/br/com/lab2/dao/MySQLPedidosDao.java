package br.com.lab2.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import br.com.lab2.entity.Pedidos;

public class MySQLPedidosDao implements PedidosDao{

	Connection cn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	@Override
	public void incluirPedido(Pedidos pedido) throws Exception {
		
		String sql="INSERT INTO PEDIDOS (IDCLIENTE,DATA,DESCRICAO,VALOR) VALUES (?,?,?,?)";
		stmt = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		stmt.setInt(1, pedido.getIdCliente());
		stmt.setDate(2, new Date(pedido.getData().getTime()));
		stmt.setString(3, pedido.getDescricao());
		stmt.setDouble(4, pedido.getValor());
		stmt.execute();
		
		//Chave gerada (Identity Keys)
		rs = stmt.getGeneratedKeys();
		if (rs.next()){
			pedido.setId(rs.getInt(1));
		}

		
	}
	@Override
	public List<Pedidos> listarPedidos(int idCliente) throws Exception {
		return null;
	}

}
