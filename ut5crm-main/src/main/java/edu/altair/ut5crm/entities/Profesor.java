package edu.altair.ut5crm.entities;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "profesores")
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profesor")
    private Long idProfesor;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "apellidos", nullable = false, length = 50)
    private String apellidos;

    @Column(name = "dni", unique = true, length = 9)
    private String dni;

    @Column(name = "email_centro", length = 200)
    private String emailCentro;

    @Column(name = "email_personal", length = 200)
    private String emailPersonal;

    @Column(name = "telefono_personal", length = 200)
    private String telefonoPersonal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "id_departamento",
            foreignKey = @ForeignKey(name = "fk_profesor_departamento")
    )
    private Departamento departamento;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "profesor_modulo",
            joinColumns = @JoinColumn(name = "id_profesor"),
            inverseJoinColumns = @JoinColumn(name = "id_modulo")
    )
    private Set<Modulo> modulos = new HashSet<>();

    public Profesor() {
    }

    public Profesor(Long idProfesor, String nombre, String apellidos, String dni, String emailCentro, String emailPersonal, String telefonoPersonal) {
        this.idProfesor = idProfesor;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.emailCentro = emailCentro;
        this.emailPersonal = emailPersonal;
        this.telefonoPersonal = telefonoPersonal;
    }

    public Long getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Long idProfesor) {
        this.idProfesor = idProfesor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmailCentro() {
        return emailCentro;
    }

    public void setEmailCentro(String emailCentro) {
        this.emailCentro = emailCentro;
    }

    public String getEmailPersonal() {
        return emailPersonal;
    }

    public void setEmailPersonal(String emailPersonal) {
        this.emailPersonal = emailPersonal;
    }

    public String getTelefonoPersonal() {
        return telefonoPersonal;
    }

    public void setTelefonoPersonal(String telefonoPersonal) {
        this.telefonoPersonal = telefonoPersonal;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Set<Modulo> getModulos() {
        return modulos;
    }

    public void setModulos(Set<Modulo> modulos) {
        this.modulos = modulos;
    }
}