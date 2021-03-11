package br.ucb.modelo;

import java.io.Serializable;

public class Creche implements Serializable{
private static final long serialVersionUID = 1L;

	private long id;
	private String cnpj;
	private String nomeCreche;
	private String nomeResponsavel;
	private String email;
	private String telefone;
	private String endereco;
	private String necessidadePrincipal;
	private String senha;
	
	public Creche() {
		
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNomeCreche() {
		return nomeCreche;
	}

	public void setNomeCreche(String nomeCreche) {
		this.nomeCreche = nomeCreche;
	}

	public String getNomeResponsavel() {
		return nomeResponsavel;
	}

	public void setNomeResponsavel(String nomeResponsavel) {
		this.nomeResponsavel = nomeResponsavel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNecessidadePrincipal() {
		return necessidadePrincipal;
	}

	public void setNecessidadePrincipal(String necessidadePrincipal) {
		this.necessidadePrincipal = necessidadePrincipal;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	
}
