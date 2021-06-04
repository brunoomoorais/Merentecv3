package br.etec.merenda.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "tb_prato")
@Entity
public class Prato extends AbstractEntity {
	private static final long serialVersionUID = 1L;
	
	@Column(name = "nm_prato", length = 100)
	private String Nome;
	
	@Column(name = "nm_descricao", length = 100)
	private String Descricao;
		

	@Column(name = "qt_peso")
	private Float Peso;
	
	
	@Column(name = "qt_valor_energetico")
	private Float ValorEnergetico;
	
	@Column(name = "qt_carboidrato")
	private Float Carboidrato;
	
	@Column(name = "qt_proteina")
	private Float Proteina;
	
	@Column(name = "qt_gordura_total")
	private Float GorduraTotal;
	
	@Column(name = "qt_gordura_trans")
	private Float GorduraTrans;
	
	@Column(name = "qt_gordura_saturada")
	private Float GorduraSaturada;
	
	@Column(name = "qt_fibra")
	private Float Fibra;
	
	@Column(name = "qt_sodio")
	private Float Sodio;
	
	public Prato() {}
	
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