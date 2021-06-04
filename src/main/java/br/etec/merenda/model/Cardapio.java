package br.etec.merenda.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@Table(name = "tb_cardapio")
@Entity
public class Cardapio {
	
	@Id
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Column(name = "dt_cardapio")
	private Date data;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_cd_prato")
	private Prato Prato;
	
	@ManyToMany(cascade = {CascadeType.REMOVE, CascadeType.PERSIST}, fetch = FetchType.EAGER)	
	private List<Usuario> usuario;
	
	public Cardapio() {}
	
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	public Prato getPrato() {
		return Prato;
	}
	
	@JsonProperty
	public void setPrato(Prato prato) {
		Prato = prato;
	}
	
	public List<Usuario> getUsuario() {
		return usuario;
	}
	
	@JsonProperty
	public void setUsuario(List<Usuario> usuario) {
		this.usuario = usuario;
	}
	
}
