package br.ucb.modelo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Doacao implements Serializable{
private static final long serialVersionUID = 1L;
	
	private String tipoDoacao;
	private Date dataDoacao;
	private long id;
	private Doador doador;
	private Creche creche;
	private Date dataAtual;
	
	public Doacao() {
		
	}
	
	public String getTipoDoacao() {
		return tipoDoacao;
	}

	public void setTipoDoacao(String tipoDoacao) {
		this.tipoDoacao = tipoDoacao;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	public Doador getDoador() {
		return doador;
	}

	public void setDoador(Doador doador) {
		this.doador = doador;
	}

	public Creche getCreche() {
		return creche;
	}

	public void setCreche(Creche creche) {
		this.creche = creche;
	}

	public Date getDataDoacao() {
		return dataDoacao;
	}

	public void setDataDoacao(Date dataDoacao) {
		this.dataDoacao = dataDoacao;
	}
	
	public String getDataDoacaoDMA() {
		return (new SimpleDateFormat("dd/MM/yyyy")).format(this.dataDoacao);
	}

	public String getDataAtual() {
		return  (new SimpleDateFormat("dd/MM/yyyy")).format(dataAtual);
	}

	public void setDataAtual(Date dataAtual) {
		this.dataAtual = dataAtual;
	}
	
	
	
}
