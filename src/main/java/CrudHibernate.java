import entity.Persona;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class CrudHibernate {

    public void insertValuesPersonas(List<Persona> personasList){
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager em = managerFactory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        MetodosAnadeObjetos metodos = new MetodosAnadeObjetos();

        try{
            tx.begin();

            for(Persona persona : personasList){
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
