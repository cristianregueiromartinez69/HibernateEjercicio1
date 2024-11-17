package entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

/**
 * Clase persona que será la entidad en la base de datos
 * @author cristian
 * @version 1.0
 */
@Entity
@Table(name = "personas", schema = "public")
public class Persona {

    /**
     * El id simboliza la clave primaria que no puede ser null
     * el colum simboliza el nombre de la columna de la tabla
     */
    @Id
    @Column(name = "id", nullable = false)
    private BigDecimal id;

    /**
     * El size simboliza el tamaño de la columna maximo
     * el colum simboliza el nombre de la columna de la tabla
     */
    @Size(max = 32)
    @Column(name = "nombre", length = 32)
    private String nombre;

    @Size(max = 32)
    @Column(name = "apellido", length = 32)
    private String apellido;

    @Column(name = "salario")
    private BigDecimal salario;

    /**
     * getter y setter de la entidad
     * @return el valor correspondiente
     */
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