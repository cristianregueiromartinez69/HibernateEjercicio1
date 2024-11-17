import entity.Persona;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Metodos metodos = new Metodos();
        List<Persona> personas = metodos.getPersonas();

        CrudHibernate crud = new CrudHibernate();

        crud.insertValuesPersonas(personas);
        crud.updateValuesPersonas(metodos);


    }
}
