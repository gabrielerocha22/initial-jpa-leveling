package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
		Pessoa p1 = new Pessoa (null, "Carlos da silva", "carlos@gmail.com");
		Pessoa p2 = new Pessoa (null, "Ana da silva", "ana@gmail.com");
		Pessoa p3 = new Pessoa (null, "josé da silva", "jose@gmail.com");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa"); 
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
//		em.persist(p1);
//		em.persist(p2);
//		em.persist(p3);
		em.getTransaction().commit();
		
		//Busca por obj no bd
		Pessoa p = em.find(Pessoa.class, 2);
		System.out.println(p);
		
		System.out.println("Fim!");
		
		em.close();
		emf.close();
		
//		System.out.println(p1);
//		System.out.println(p2);
//		System.out.println(p3);
	}

}
