package br.com.fiap;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.dao.Helper;
import br.com.fiap.entity.Loja;
import br.com.fiap.entity.Oferta;
import br.com.fiap.entity.Produto;

public class App {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("DBComparador");
		EntityManager em = emf.createEntityManager();
		incluirLoja(em);
		listarLoja(em);
		buscarLoja(em, "2000");
	}
	
	private static void incluirLoja(EntityManager em){
		Helper dao = new Helper(em);
		Loja loja = new Loja();
		
		Oferta oferta = new Oferta();
		oferta.setPreco(30.00d);
		oferta.setAtivo(true);
		Set<Oferta> ofertas = new HashSet<>();
		ofertas.add(oferta);
		
		Produto prod = new Produto();
		prod.setNome("Moto z");
		prod.setOfertas(ofertas);
		Set<Produto> ps = new HashSet<>();
		ps.add(prod);		
		
		loja.setNome("MOTOROLA");
		loja.setProdutos(ps);
		
		try {
			dao.salvar(funcionario);
			System.out.println("Funcionario OK");
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	private static void listarFuncionarios(EntityManager em){
		Helper dao = new Helper(em);
		List<Funcionario> funcionarios = dao.listarTodos();
		for (Funcionario funcionario : funcionarios) {
			System.out.println(funcionario.getMatricula() + ": " +
					funcionario.getAtivo());
		}
		em.close();
	}
	private static void buscarFuncionario(EntityManager em, String
			matricula){
		Helper dao = new Helper(em);
		Funcionario f = dao.buscarFuncionario(matricula);
		System.out.println(f.getMatricula() + ": " + f.getAtivo());
	}

}
