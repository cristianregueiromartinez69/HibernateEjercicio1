import entity.Persona;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Metodos {

    public List<Persona> getPersonas() {
        List<Persona> personas = new ArrayList<>();

        Persona persona1 = new Persona();
        persona1.setId(BigDecimal.valueOf(1));
        persona1.setNombre("luis");
        persona1.setApellido("perez");
        persona1.setSalario(BigDecimal.valueOf(2000.4));

        Persona persona2 = new Persona();
        persona2.setId(BigDecimal.valueOf(2));
        persona2.setNombre("ana");
        persona2.setApellido("suarez");
        persona2.setSalario(BigDecimal.valueOf(2100.427));

        Persona persona3 = new Persona();
        persona3.setId(BigDecimal.valueOf(3));
        persona3.setNombre("pedro");
        persona3.setApellido("aquinho");
        persona3.setSalario(BigDecimal.valueOf(1500.6123254));

        personas.add(persona1);
        personas.add(persona2);
        personas.add(persona3);

        return personas;
    }

    public Persona updatePersona(){
        Persona persona = new Persona();
        persona.setId(BigDecimal.valueOf(2));
        persona.setNombre("juana");
        persona.setApellido("gonzalez");
        persona.setSalario(BigDecimal.valueOf(3200.4500));
        return persona;
    }
}


