package br.com.fiap.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "OFERTA", catalog = "DBComparador")

@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY, region = "loja")
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

}
