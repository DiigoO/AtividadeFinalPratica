package br.com.fiap.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "LOJA", catalog = "DBComparador", uniqueConstraints = {@UniqueConstraint(columnNames = "CODIGO_LOJA") })
@NamedQuery(name = "Loja.findAll", query = "select l from Loja l", hints = {@QueryHint(name = "org.hibernate.cacheable", value = "true") })
public class Loja implements Serializable {

	private static final long serialVersionUID = 8363694679454120193L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "NOME_LOJA", unique = true, nullable = false, length = 45)
	private String nome;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "loja")
	private Set<Produto> usuarios = new HashSet<Produto>();

}
