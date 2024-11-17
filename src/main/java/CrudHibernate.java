import entity.Persona;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;
import java.util.List;

/**
 * Clase con los metodos crud de hibernate
 * @author cristian
 * @version 1.0
 */
public class CrudHibernate {

    /**
     * Metodo para insertar valores en la base de datos con hibernate
     * @param personasList la lista de personas
     */
    public void insertValuesPersonas(List<Persona> personasList){
        /*
          Explicacion:
          1. Creamos los objetos necesarios para operar con hibernate
          2. iniciamos la transaccion
          3. metemos el codigo dentro de un try-cacth
          4. tx.begin(); -> Significa que podemos empezar a mandar las consultas pero no se enviarán hasta poner el commit
          5. llamamos al metodo persists para insertar los resultados a la base de datos
          6. cerramos con .commit()
          7. finalmente preguntamos si la transaccion sigue activa o hubo algun problema
          8. si es así, hacemos un rollback para que no se envía nada
         */
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager em = managerFactory.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try (managerFactory; em) {
            tx.begin();

            for (Persona persona : personasList) {
                em.persist(persona);
            }
            tx.commit();
        } finally {
            if (tx.isActive()) {
                tx.rollback();
            }
        }
    }

    /**
     * Metodo para actualizar valores en la base de datos con hibernate
     * @param metodos el metodo que devuelve una Persona
     */
    public void updateValuesPersonas(Metodos metodos){
        /*
          Explicacion:
          1. Creamos los objetos necesarios para operar con hibernate
          2. iniciamos la transaccion
          3. metemos el codigo dentro de un try-cacth
          4. tx.begin(); -> Significa que podemos empezar a mandar las consultas pero no se enviarán hasta poner el commit
          5. llamamos al metodo merge para actualizar los resultados de la base de datos
          6. cerramos con .commit()
          7. finalmente preguntamos si la transaccion sigue activa o hubo algun problema
          8. si es así, hacemos un rollback para que no se envía nada
         */
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager em = managerFactory.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try (managerFactory; em) {
            tx.begin();
            em.merge(metodos.updatePersona());
            tx.commit();
        } finally {
            if (tx.isActive()) {
                tx.rollback();
            }
        }
    }

    /**
     * Metodo para eliminar valores en la base de datos con hibernate
     * @param id clave primaria del elemento a eliminar
     */
    public void deletePersona(BigDecimal id) {
        /*
          Explicacion:
          1. Creamos los objetos necesarios para operar con hibernate
          2. iniciamos la transaccion
          3. metemos el codigo dentro de un try-cacth
          4. tx.begin(); -> Significa que podemos empezar a mandar las consultas pero no se enviarán hasta poner el commit
          5. llamamos al metodo remove para eliminar los resultados de la base de datos
          6. cerramos con .commit()
          7. finalmente preguntamos si la transaccion sigue activa o hubo algun problema
          8. si es así, hacemos un rollback para que no se envía nada
         */
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager em = managerFactory.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Persona persona = em.find(Persona.class, id);
            if (persona != null) {
                em.remove(persona);
            }
            tx.commit();
        } finally {
            if (tx.isActive()) {
                tx.rollback();
            }
            em.close();
            managerFactory.close();
        }
    }
}
