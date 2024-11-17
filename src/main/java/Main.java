import entity.Persona;

import java.math.BigDecimal;
import java.util.List;

/**
 * Clase main donde ejecutamos el programa
 * @author cristian
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) {
        //Instanciamos el objeto de metodos
        Metodos metodos = new Metodos();
        //hacemos una lista con el metodo que me devuelve una lista de objetos de tipo persona
        List<Persona> personas = metodos.getPersonas();

        //instanciamos un objeto de la clase CrudHibernate
        CrudHibernate crud = new CrudHibernate();

        //llamamos a los metodos que operan con la base de datos con hibernate
        crud.insertValuesPersonas(personas);
        crud.updateValuesPersonas(metodos);
        crud.deletePersona(BigDecimal.valueOf(3));


    }
}
