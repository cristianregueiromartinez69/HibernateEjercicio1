import entity.Persona;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager em = managerFactory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        Metodos metodos = new Metodos();

        try{
            tx.begin();
            List<Persona> personas = metodos.getPersonas();

            for(Persona persona : personas){
                em.persist(persona);
            }
            tx.commit();
        }finally{
            if(tx.isActive()){
                tx.rollback();
            }
            em.close();
            managerFactory.close();
        }
    }
}
