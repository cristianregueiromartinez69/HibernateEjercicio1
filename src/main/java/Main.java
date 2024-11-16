import entity.Persona;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        MetodosAnadeObjetos metodosAnadeObjetos = new MetodosAnadeObjetos();
        List<Persona> personas = metodosAnadeObjetos.getPersonas();

        CrudHibernate crud = new CrudHibernate();

        crud.insertValuesPersonas(personas);


    }
}
