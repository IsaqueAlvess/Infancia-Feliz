package br.ucb.modelo.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.ucb.modelo.Doador;

public class DoadorDAO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Connection con;
	
	public DoadorDAO() throws SQLException {
			this.con = ConnectionFactory.getConnection();
	}
	
	public int cadastrar(Doador doador) throws SQLException{
		if (doador == null)
			return 0;
		String sql="INSERT INTO doador (nome,telefone,email,senha) VALUES (?, ?, ?, ?);";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1,doador.getNome());
		stmt.setString(2,doador.getTelefone());
		stmt.setString(3,doador.getEmail());
		stmt.setString(4,doador.getSenha());
		
		int retorno = stmt.executeUpdate();
		stmt.close();
		return retorno;
	}
	
	public Doador consultar (long id) throws SQLException{
		Doador doador = null;
		
		String sql ="SELECT * FROM doador WHERE id=?";
		PreparedStatement stmt = this.con.prepareStatement(sql);
		stmt.setLong(1, id);
		ResultSet rs = stmt.executeQuery();
		
		if(rs.first()) {		
			doador = new Doador();
			
			doador.setId(rs.getLong("id"));
			doador.setNome(rs.getString("nome"));
			doador.setEmail(rs.getString("email"));
			doador.setTelefone(rs.getString("telefone"));
			doador.setSenha(rs.getString("senha"));
		}
		rs.close();
		stmt.close();
		return doador;
	}
	
	
	public Doador logarDoador(String email, String senha) throws SQLException{
		Doador doador = null;
			
		String sql = "SELECT * FROM doador WHERE email = ? AND senha = ? ; ";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1,email);
		stmt.setString(2,senha);
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			
			doador = new Doador();
			doador.setId(rs.getLong("id"));
			doador.setNome(rs.getString("nome"));
			doador.setEmail(rs.getString("email"));
			doador.setTelefone(rs.getString("telefone"));
			doador.setSenha(rs.getString("senha"));
			
		}
		rs.close();
		stmt.close();
		return doador;
	}
	public int editar (Doador doador) throws SQLException{
		if (doador == null)
			return 0;
		String sql="UPDATE doador SET nome=?, telefone=?, email=?, senha=? WHERE id=? ";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1,doador.getNome());
		stmt.setString(2,doador.getTelefone());
		stmt.setString(3,doador.getEmail());
		stmt.setString(4,doador.getSenha());
		stmt.setLong(5,doador.getId());
				
		int retorno = stmt.executeUpdate();
		 stmt.close();
			System.out.println("Sucesso!");
		return retorno;
	}
	public int excluir(Long id) throws SQLException {
		if (id == null)
			return 0;
		String sql="DELETE FROM doador WHERE id=?";
		PreparedStatement stmt = this.con.prepareStatement(sql);
		stmt.setLong(1,id);		
		int retorno = stmt.executeUpdate();
		stmt.close();
		return retorno;
	}
		

}
