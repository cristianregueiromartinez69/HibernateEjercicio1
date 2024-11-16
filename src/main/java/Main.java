import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager em = managerFactory.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try{
            tx.begin();

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
