package br.com.fiap;

import java.util.HashSet;
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
		
		Integer option = Integer.valueOf(JOptionPane.showInputDialog("Digite o que deseja inserir\n1 - LOJA\n2 - PRODUTO\n3 - OFERTA"));
		switch (option) {
		case(1):
			inserirLoja(em);
			break;
		case(2):
			inserirProduto(em);
			break;
		case(3):
			inserirOferta(em);
			break;
		}
	}
	
	private static void inserirLoja(EntityManager em) {
		Helper dao = new Helper(em);
		String nomeLoja = JOptionPane.showInputDialog("Digite o nome da Loja");
		Loja loja = new Loja();
		loja.setNome(nomeLoja);

		try {
			dao.salvar(loja);
			System.out.println("Loja OK");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static void inserirProduto(EntityManager em) {
		Helper dao = new Helper(em);
		String nomeLoja = JOptionPane.showInputDialog("Digite o nome da Loja");
		Loja loja = dao.buscarLoja(nomeLoja);
		if(loja != null) {
			String nomeProduto = JOptionPane.showInputDialog("Digite o nome do Produto");
			Produto produto = new Produto();
			produto.setNome(nomeProduto);
			
			if(loja.getProdutos() != null)
				loja.getProdutos().add(produto);
			else {
				Set<Produto> produtos = new HashSet<>();
				produtos.add(produto);
				loja.setProdutos(produtos);
			}
	
			try {
				dao.salvar(loja);
				System.out.println("Produto OK");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Loja nao existe!");
		}
	}
	
	private static void inserirOferta(EntityManager em) {
		Helper dao = new Helper(em);
		String nomeLoja = JOptionPane.showInputDialog("Digite o nome da Loja");
		Loja loja = dao.buscarLoja(nomeLoja);
		if(loja != null) {
			String nomeProduto = JOptionPane.showInputDialog("Digite o nome do Produto");
			Produto produto = dao.buscarProduto(nomeProduto);
			
			if(produto != null) {
				Double valorOfert = null;
				try {
					valorOfert = Double.valueOf(JOptionPane.showInputDialog("Digite o valor da Produto"));
				}
				catch(NumberFormatException e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Valor invalido!");
					return;
					
				}
				Oferta oferta = new Oferta();
				oferta.setAtivo(true);
				oferta.setPreco(valorOfert);
				
				if(produto.getOfertas() != null)
					produto.getOfertas().add(oferta);
				else {
					Set<Oferta> ofertas = new HashSet<>();
					ofertas.add(oferta);
					produto.setOfertas(ofertas);
				}
		
				try {
					dao.salvar(produto);
					System.out.println("Oferta OK");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "Produto nao existe!");	
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Loja nao existe!");
		}
	}

}
