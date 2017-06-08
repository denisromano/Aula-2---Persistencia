package br.com.lab2.dao;

public abstract class DaoFactory {
	// Lista de tipos suportados pelo factory
	public static final int MYSQL = 1;
	public static final int SQLSERVER = 2;


	public abstract ClientesDao getClientesDao();

	public abstract PedidosDao getPedidosDao();

	public static DaoFactory getDaoFactory(int tipo) {
		switch (tipo) {
		case MYSQL:
			return new MySQLDaoFactory();
		case SQLSERVER:
			return new SqlServerDaoFactory();
		default:
			return null;
		}
	}
}
