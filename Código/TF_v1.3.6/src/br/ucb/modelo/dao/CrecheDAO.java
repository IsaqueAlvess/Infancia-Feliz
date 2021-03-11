package br.ucb.modelo.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.ucb.modelo.Creche;

public class CrecheDAO implements Serializable{

	private static final long serialVersionUID = 1L;
	private Connection con;
	
	public CrecheDAO() throws SQLException {
			this.con = ConnectionFactory.getConnection();
	}
	
	public int cadastrarCreche(Creche creche) throws SQLException{
		if(creche == null)
			return 0;
		String sql = "INSERT INTO creche (cnpj, nomeCreche, nomeResponsavel, email, telefone, necessidadePrincipal, endereco, senha) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1,creche.getCnpj());
		stmt.setString(2,creche.getNomeCreche());
		stmt.setString(3,creche.getNomeResponsavel());
		stmt.setString(4,creche.getEmail());
		stmt.setString(5,creche.getTelefone());
		stmt.setString(6,creche.getNecessidadePrincipal());
		stmt.setString(7,creche.getEndereco());
		stmt.setString(8,creche.getSenha());
		
		int retorno = stmt.executeUpdate();
		 stmt.close();
		return retorno;
		
	}
	
	public Creche logarCreche(String email, String senha) throws SQLException{
		Creche creche = null;
		
		String sql = "SELECT * FROM creche WHERE email = ? AND senha = ? ; ";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, email);
		stmt.setString(2, senha);
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			
			creche = new Creche();
			creche.setId(rs.getLong("id"));
			creche.setCnpj(rs.getString("cnpj"));
			creche.setNomeCreche(rs.getString("nomeCreche"));
			creche.setNomeResponsavel(rs.getString("nomeResponsavel"));
			creche.setEmail(rs.getString("email"));
			creche.setEndereco(rs.getString("endereco"));
			creche.setTelefone(rs.getString("telefone"));
			creche.setNecessidadePrincipal(rs.getString("necessidadePrincipal"));
			creche.setSenha(rs.getString("senha"));
			
		}
		rs.close();
		stmt.close();
		return creche;
	}
	
	public Creche consultar(long id) throws SQLException{
		Creche creche = null;
	
		String sql = "SELECT * FROM creche WHERE id=?";
		PreparedStatement stmt = this.con.prepareStatement(sql);
		stmt.setLong(1,id);
		ResultSet rs = stmt.executeQuery();
		
		if(rs.first()) {
			creche = new Creche();
			
			creche.setId(rs.getLong("id"));
			creche.setCnpj(rs.getString("cnpj"));
			creche.setNomeCreche(rs.getString("nomeCreche"));
			creche.setNomeResponsavel(rs.getString("nomeResponsavel"));
			creche.setEmail(rs.getString("email"));
			creche.setEndereco(rs.getString("endereco"));
			creche.setTelefone(rs.getString("telefone"));
			creche.setNecessidadePrincipal(rs.getString("necessidadePrincipal"));
			creche.setSenha(rs.getString("senha"));
						
		}
		rs.close();
		stmt.close();
		return creche;	
	}
	
	public int editar (Creche creche) throws SQLException{
		if(creche == null)
			return 0;
		String sql = "UPDATE creche SET cnpj=?, nomeCreche=?, nomeResponsavel=?, email=?, telefone=?, endereco=?,necessidadePrincipal=?,  senha=? WHERE id=? ;";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1,creche.getCnpj());
		stmt.setString(2,creche.getNomeCreche());
		stmt.setString(3,creche.getNomeResponsavel());
		stmt.setString(4,creche.getEmail());
		stmt.setString(5,creche.getTelefone());
		stmt.setString(6,creche.getEndereco());
		stmt.setString(7,creche.getNecessidadePrincipal());
		stmt.setString(8,creche.getSenha());
		stmt.setLong(9, creche.getId());
		
		int retorno = stmt.executeUpdate();
		 stmt.close();
			System.out.println("Sucesso!");
		return retorno;
		
	}
	public int excluir(Long id) throws SQLException {
		if (id == null)
			return 0;
		String sql="DELETE FROM creche WHERE id=?";
		PreparedStatement stmt = this.con.prepareStatement(sql);
		stmt.setLong(1,id);		
		int retorno = stmt.executeUpdate();
		stmt.close();
		return retorno;
	}
		
}
