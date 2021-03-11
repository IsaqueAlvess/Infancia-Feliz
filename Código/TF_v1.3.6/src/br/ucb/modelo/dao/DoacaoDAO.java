package br.ucb.modelo.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.ucb.modelo.Creche;
import br.ucb.modelo.Doacao;

public class DoacaoDAO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Connection con;
	
	public DoacaoDAO() throws SQLException {
			this.con = ConnectionFactory.getConnection();
	}
	
	public List<Creche> listar(Doacao doacao) throws SQLException {
		String sql = "SELECT id, cnpj, nomeCreche, nomeResponsavel, email, endereco, telefone, necessidadePrincipal FROM creche WHERE necessidadePrincipal=?";
		PreparedStatement stmt = this.con.prepareStatement(sql);
		stmt.setString(1,doacao.getTipoDoacao());
		
		ResultSet rs = stmt.executeQuery();
		List<Creche> creches = new ArrayList<Creche>();

		while (rs.next()) {
			Creche creche = new Creche();
			
			creche.setId(rs.getLong("id"));
			creche.setCnpj(rs.getString("cnpj"));
			creche.setNomeCreche(rs.getString("nomeCreche"));
			creche.setNomeResponsavel(rs.getString("nomeResponsavel"));
			creche.setEmail(rs.getString("email"));
			creche.setEndereco(rs.getString("endereco"));
			creche.setTelefone(rs.getString("telefone"));
			creche.setNecessidadePrincipal(rs.getString("necessidadePrincipal"));
			
			creches.add(creche);
		}
		rs.close();
		stmt.close();
		return creches;	
	}
	
	public int cadastrar(Doacao doacao) throws SQLException {
		if(doacao == null)
			return 0;
		String sql = "INSERT INTO doacao (tipoDoacao, dataDoacao, doador_id, creche_id) VALUES (?,?,?,?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1,doacao.getTipoDoacao());
		
		java.sql.Date data = new java.sql.Date(doacao.getDataDoacao().getTime());
		stmt.setDate(2, data);
		
		stmt.setLong(3, doacao.getDoador().getId());
		stmt.setLong(4, doacao.getCreche().getId());
		
		int retorno = stmt.executeUpdate();
		stmt.close();
		return retorno;
	}
	
	
	public List<Doacao> listar(long id) throws SQLException{
		
		
		String sql="SELECT * from doacao INNER JOIN doador ON doador.id=doacao.doador_id WHERE doacao.dataDoacao >= curdate() AND doador.id = ?";
		PreparedStatement stmt = this.con.prepareStatement(sql);
		stmt.setLong(1,id);
		ResultSet rs = stmt.executeQuery();
		List<Doacao> doacoes = new ArrayList<Doacao>();
		CrecheDAO crecheDAO = new CrecheDAO();
		DoadorDAO doadorDAO = new DoadorDAO();   // (tipoDoacao, dataDoacao, doador_id, creche_id)
		while(rs.next()) {
			Doacao doacao = new Doacao();
			
			doacao.setId(rs.getLong("id"));
			doacao.setTipoDoacao(rs.getString("tipoDoacao"));
			doacao.setDataDoacao(rs.getDate("dataDoacao"));
			doacao.setDoador(doadorDAO.consultar(rs.getLong("doador_id")));
			doacao.setCreche(crecheDAO.consultar(rs.getLong("creche_id")));
			
			doacoes.add(doacao);
		}
		rs.close();
		stmt.close();
		return doacoes;
	}
	
	public List<Doacao> listarDoacoesFeitas_Doador(long id) throws SQLException{
				
		String sql="SELECT * FROM doacao INNER JOIN doador ON doador.id=doacao.doador_id WHERE doacao.dataDoacao < curdate() AND doador.id=?";
		PreparedStatement stmt = this.con.prepareStatement(sql);
		stmt.setLong(1,id);
		ResultSet rs = stmt.executeQuery();
		List<Doacao> doacoes = new ArrayList<Doacao>();
		CrecheDAO crecheDAO = new CrecheDAO();
		DoadorDAO doadorDAO = new DoadorDAO();   // (tipoDoacao, dataDoacao, doador_id, creche_id)
		while(rs.next()) {
			Doacao doacao = new Doacao();
			
			doacao.setId(rs.getLong("id"));
			doacao.setTipoDoacao(rs.getString("tipoDoacao"));
			doacao.setDataDoacao(rs.getDate("dataDoacao"));
			doacao.setDoador(doadorDAO.consultar(rs.getLong("doador_id")));
			doacao.setCreche(crecheDAO.consultar(rs.getLong("creche_id")));
			
			doacoes.add(doacao);
		}
		rs.close(); 
		stmt.close();
		return doacoes;
	}
	
	//CRECHE
	
	public List<Doacao> listarDoacoesAgendadas_Creche(long id) throws SQLException{
		
		
		String sql="SELECT * from doacao INNER JOIN creche ON creche.id=doacao.creche_id WHERE doacao.dataDoacao >= curdate() AND creche.id = ?";
		PreparedStatement stmt = this.con.prepareStatement(sql);
		stmt.setLong(1,id);
		ResultSet rs = stmt.executeQuery();
		List<Doacao> doacoes = new ArrayList<Doacao>();
		CrecheDAO crecheDAO = new CrecheDAO();
		DoadorDAO doadorDAO = new DoadorDAO();   // (tipoDoacao, dataDoacao, doador_id, creche_id)
		while(rs.next()) {
			Doacao doacao = new Doacao();
			
			doacao.setId(rs.getLong("id"));
			doacao.setTipoDoacao(rs.getString("tipoDoacao"));
			doacao.setDataDoacao(rs.getDate("dataDoacao"));
			doacao.setDoador(doadorDAO.consultar(rs.getLong("doador_id")));
			doacao.setCreche(crecheDAO.consultar(rs.getLong("creche_id")));
			
			doacoes.add(doacao);
		}
		rs.close();
		stmt.close();
		return doacoes;
	}
	
	public List<Doacao> listarDoacoesRecebidas(long id) throws SQLException{
				
		String sql="SELECT * FROM doacao INNER JOIN creche ON creche.id=doacao.creche_id WHERE doacao.dataDoacao < curdate() AND creche.id = ?";
		PreparedStatement stmt = this.con.prepareStatement(sql);
		stmt.setLong(1,id);
		ResultSet rs = stmt.executeQuery();
		List<Doacao> doacoes = new ArrayList<Doacao>();
		CrecheDAO crecheDAO = new CrecheDAO();
		DoadorDAO doadorDAO = new DoadorDAO();   // (tipoDoacao, dataDoacao, doador_id, creche_id)
		while(rs.next()) {
			Doacao doacao = new Doacao();
			
			doacao.setId(rs.getLong("id"));
			doacao.setTipoDoacao(rs.getString("tipoDoacao"));
			doacao.setDataDoacao(rs.getDate("dataDoacao"));
			doacao.setDoador(doadorDAO.consultar(rs.getLong("doador_id")));
			doacao.setCreche(crecheDAO.consultar(rs.getLong("creche_id")));
			
			doacoes.add(doacao);
		}
		rs.close(); 
		stmt.close();
		return doacoes;
	}
	
	

	public int excluir(Long id) throws SQLException {
		if(id == null)
			return 0;
		String sql="DELETE FROM doacao WHERE id=?";
		PreparedStatement stmt = this.con.prepareStatement(sql);
		stmt.setLong(1,id);
		int retorno = stmt.executeUpdate();
		stmt.close();
		System.out.println("Sucesso dao");
		return retorno;
	}
	
	
}
