package entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

@Entity
@Table(name = "personas", schema = "public")
public class Persona {

    @Id
    @Column(name = "id", nullable = false)
    private BigDecimal id;

    @Size(max = 32)
    @Column(name = "nombre", length = 32)
    private String nombre;

    @Size(max = 32)
    @Column(name = "apellido", length = 32)
    private String apellido;

    @Column(name = "salario")
    private BigDecimal salario;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

}