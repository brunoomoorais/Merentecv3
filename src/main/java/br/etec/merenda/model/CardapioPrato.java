package br.etec.merenda.model;

import java.util.Date;

public class CardapioPrato {
	
	private Date Data;
	
	private String Nome;
	
	private String Descricao;
		
	private Float Peso;
		
	private Float ValorEnergetico;
	
	private Float Carboidrato;
	
	private Float Proteina;
	
	private Float GorduraTotal;
	
	private Float GorduraTrans;
	
	private Float GorduraSaturada;
	
	private Float Fibra;
	
	private Float Sodio;

	public Date getData() {
		return Data;
	}

	public void setData(Date data) {
		Data = data;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}

	public Float getPeso() {
		return Peso;
	}

	public void setPeso(Float peso) {
		Peso = peso;
	}

	public Float getValorEnergetico() {
		return ValorEnergetico;
	}

	public void setValorEnergetico(Float valorEnergetico) {
		ValorEnergetico = valorEnergetico;
	}

	public Float getCarboidrato() {
		return Carboidrato;
	}

	public void setCarboidrato(Float carboidrato) {
		Carboidrato = carboidrato;
	}

	public Float getProteina() {
		return Proteina;
	}

	public void setProteina(Float proteina) {
		Proteina = proteina;
	}

	public Float getGorduraTotal() {
		return GorduraTotal;
	}

	public void setGorduraTotal(Float gorduraTotal) {
		GorduraTotal = gorduraTotal;
	}

	public Float getGorduraTrans() {
		return GorduraTrans;
	}

	public void setGorduraTrans(Float gorduraTrans) {
		GorduraTrans = gorduraTrans;
	}

	public Float getGorduraSaturada() {
		return GorduraSaturada;
	}

	public void setGorduraSaturada(Float gorduraSaturada) {
		GorduraSaturada = gorduraSaturada;
	}

	public Float getFibra() {
		return Fibra;
	}

	public void setFibra(Float fibra) {
		Fibra = fibra;
	}

	public Float getSodio() {
		return Sodio;
	}

	public void setSodio(Float sodio) {
		Sodio = sodio;
	}
	
	
	
}
