package br.com.documentprocessing.jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {
	
	public static java.sql.Connection getConnection(){
		java.sql.Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/database_document_processing","postgres","12345");
			System.out.println("Conectado com Sucesso!");
			
		} catch (SQLException e) {
			System.out.println("Erro ao conectar: " + e.getMessage());
		}
		return connection;
	}
}
