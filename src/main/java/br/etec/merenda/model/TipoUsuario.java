package br.etec.merenda.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "tb_tipo_usuario")
@Entity
public class TipoUsuario extends AbstractEntity{	
	private static final long serialVersionUID = 1L;
	@Column(name = "nm_tipo_usuario")
	private String TipoUsuario;
	
	public String getTipoUsuario() {
		return TipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		TipoUsuario = tipoUsuario;
	}

	public TipoUsuario() {}
	
	
}	
