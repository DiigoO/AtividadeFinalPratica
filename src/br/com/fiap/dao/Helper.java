package br.com.fiap.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.fiap.entity.Loja;

public class Helper {
	private EntityManager em;

	public Helper(EntityManager em){
		this.em = em;
	}

	public void salvar(Object loja) throws Exception { 
		try {
			em.getTransaction().begin(); 
			em.persist(loja); 
			em.getTransaction().commit();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//JPQL: Usando Query
	@SuppressWarnings("unchecked")
	public List<Loja> listarlojas(){
		Query query = em.createQuery("select * from Lojas"); 
		return query.getResultList();
		
	}

	public Loja buscarLoja(String name){
		Query query = em.createQuery("select * from Loja where lojaId = :lojaId");
		query.setParameter("lojaId", name); 
		Loja l = (Loja) query.getSingleResult(); 
		return l;		
	}
	
	public Loja buscarLoja(int id){
		Loja loja = this.em.find(Loja.class, id);
		return loja;
	}
}
