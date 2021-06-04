package br.etec.merenda.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

/*@Table(name = "tb_reserva")
@Entity*/
public class Reserva implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_dt_cardapio")
	private Cardapio Cardapio;
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_nm_login_usuario")
	private Usuario Usuario;
	
	public Reserva() {}

	public Cardapio getCardapio() {
		return Cardapio;
	}
	
	@JsonProperty
	public void setCardapio(Cardapio cardapio) {
		Cardapio = cardapio;
	}

	public Usuario getUsuario() {
		return Usuario;
	}
	
	@JsonProperty
	public void setUsuario(Usuario usuario) {
		Usuario = usuario;
	}
}
