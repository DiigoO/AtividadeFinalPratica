package br.com.fiap.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "OFERTA", catalog = "DBComparador")
public class Oferta implements Serializable {

	private static final long serialVersionUID = -2013892684447236809L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "PRECO", nullable = false)
	private Double preco;
	
	@Column(name = "ATIVO", nullable = false)
	private Boolean nome;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Boolean getNome() {
		return nome;
	}

	public void setNome(Boolean nome) {
		this.nome = nome;
	}
	
	

}
