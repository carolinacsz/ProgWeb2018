package br.edu.ifg.proi.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifg.proi.jdbc.ConnectionFactory;
import br.edu.ifg.proi.jdbc.modelo.Cliente;
import br.edu.ifg.proi.jdbc.modelo.Cliente;

public class ClienteDAO {

	private Connection connection;

	public ClienteDAO() throws SQLException {
		this.connection = new ConnectionFactory().getConnection();
		
		//Cria a tabela no banco caso nao exista
		criarTabela();
	}
	
	public void criarTabela() throws SQLException{
		try {
			String sql = "CREATE TABLE IF NOT EXISTS cliente (" + "id BIGINT NOT NULL AUTO_INCREMENT,"
					+ "cpf VARCHAR(14)," + "nome VARCHAR(255)," + "contato VARCHAR(255)," + "email VARCHAR(255)," 
					+ "usuario VARCHAR(255) UNIQUE," + "senha VARCHAR(100),"	+ "primary key (id)" + ");";

			// Criando o statement
			Statement st = connection.createStatement();

			// Executando a consulta
			int i = st.executeUpdate(sql);
			if (i == -1) {
				throw new RuntimeException("db error : " + sql);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void create(Cliente cliente) {
		String sql = "insert into cliente " + "(cpf,nome,contato,email,usuario,senha)" + " values (?,?,?,?,?,?)";
		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores
			stmt.setString(1, cliente.getCpf());
			stmt.setString(2, cliente.getNome());
			stmt.setString(3, cliente.getContato());
			stmt.setString(4, cliente.getEmail());
			stmt.setString(5, cliente.getUsuario());
			stmt.setString(6, cliente.getSenha());

			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void update(Cliente cliente) {
		try {
			String sql = "UPDATE CLIENTE SET cpf = ?, nome = ?, contato = ?, email = ?, usuario = ?, senha = ? WHERE id = ?;";

			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, cliente.getCpf());
			stmt.setString(2, cliente.getNome());
			stmt.setString(3, cliente.getContato());
			stmt.setString(4, cliente.getEmail());
			stmt.setString(5, cliente.getUsuario());
			stmt.setString(6, cliente.getSenha());
			stmt.setLong(7, cliente.getId());

			stmt.execute();
			stmt.close();

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void delete(String usuario){
		String sql = "select * from cliente where usuario = (?)";
		try {
			List<Cliente> clientes = new ArrayList<Cliente>();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, usuario);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()){
				Cliente cli = new Cliente();
				cli.setUsuario(rs.getString("usuario"));
				cli.setNome(rs.getString("nome"));
				
				clientes.add(cli);
			}
			if(clientes.isEmpty()){
				System.out.println("Usuario nao encontrado!");
			}else{
				String sql2 = "delete from cliente where usuario = ?";
				PreparedStatement stmt2 = connection.prepareStatement(sql2);
				stmt2.setString(1, usuario);
			}
		} catch (SQLException e){
			throw new RuntimeException(e);
		}
	}
}
