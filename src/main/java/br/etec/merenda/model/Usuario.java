package br.etec.merenda.model;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Table(name = "tb_usuario")
@Entity
public class Usuario extends AbstractEntity{	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "nm_login")
	private String login;
	
	@Column(name = "nm_usuario")
	private String Nome;
	
	@Column(name = "nm_senha")
	private String Senha;
	
	/*@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_cd_tipo_usuario")
	private TipoUsuario TipoUsuario;*/
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "tb_perfil")
	private Set<Integer> perfis = new HashSet<>();

	public Set<TipoPerfil> getPerfis() {
		return perfis.stream().map(x -> TipoPerfil.toEnum(x)).collect(Collectors.toSet());
	}

	
	public Usuario() {}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		this.Nome = nome;
	}

	@JsonIgnore
	public String getSenha() {
		return Senha;
	}
	
	@JsonProperty
	public void setSenha(String senha) {
		this.Senha = senha;
	}

	/*public TipoUsuario getTipoUsuario() {
		return TipoUsuario;
	}
	
	@JsonProperty
	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		TipoUsuario = tipoUsuario;
	}	*/
}
