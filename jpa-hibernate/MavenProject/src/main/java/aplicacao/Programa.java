package aplicacao;

import dominio.Pessoa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Programa {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
        EntityManager em = emf.createEntityManager(); // Conexão de banco de dados

        Pessoa p = em.find(Pessoa.class, 2);
        System.out.println(p);

        System.out.println("Pronto");
        em.close();
        emf.close();

    }
}
