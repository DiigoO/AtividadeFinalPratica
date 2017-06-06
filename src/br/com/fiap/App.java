package br.com.fiap;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import br.com.fiap.dao.Helper;
import br.com.fiap.entity.Loja;
import br.com.fiap.entity.Oferta;
import br.com.fiap.entity.Produto;

public class App {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("DBComparador");
		EntityManager em = emf.createEntityManager();
		incluirLoja(em);
//		listarLoja(em);
//		buscarLoja(em, "2000");
	}
	
	private static void incluirLoja(EntityManager em){
		Helper dao = new Helper(em);
		Loja loja = new Loja();
		
		Oferta oferta = new Oferta();
		Set<Oferta> ofertas = new HashSet<>();		
		Produto prod = new Produto();
		Set<Produto> ps = new HashSet<>();
		
		String l = JOptionPane.showInputDialog("Digite uma loja: ");
		loja.setNome(l);
		String p = JOptionPane.showInputDialog("Digite um produto: ");
		String pr = JOptionPane.showInputDialog("Digite seu preço: ");
		String at = JOptionPane.showInputDialog("Digite 1 se ativa ou 0 se inativa:");
		oferta.setPreco(Double.valueOf(pr));
		oferta.setAtivo(Boolean.valueOf(at));
		ofertas.add(oferta);
		
		prod.setOfertas(ofertas);
		ps.add(prod);	
		
//		try {
//			dao.salvar(funcionario);
//			System.out.println("Funcionario OK");
//		} 
//		catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
	}
//	private static void listarFuncionarios(EntityManager em){
//		Helper dao = new Helper(em);
//		List<Funcionario> funcionarios = dao.listarTodos();
//		for (Funcionario funcionario : funcionarios) {
//			System.out.println(funcionario.getMatricula() + ": " +
//					funcionario.getAtivo());
//		}
//		em.close();
//	}
//	private static void buscarFuncionario(EntityManager em, String
//			matricula){
//		Helper dao = new Helper(em);
//		Funcionario f = dao.buscarFuncionario(matricula);
//		System.out.println(f.getMatricula() + ": " + f.getAtivo());
//	}

}
