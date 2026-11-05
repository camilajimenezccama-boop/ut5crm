package edu.altair.ut5crm.entities;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "alumnos")
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alumno")
    private Long idAlumno;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "apellidos", nullable = false, length = 100)
    private String apellido;

    @Column(name = "dni", nullable = false, unique = true, length = 9)
    private String dni;

    @Column(name = "numero_ss", nullable = true, unique = true, length = 12)
    private String numeroSS;

    @Column(name = "email_personal", nullable = true, length = 254)
    private String emailPersonal;

    @Column(name = "telefono_personal", nullable = true, length = 9)
    private String telefonoPersonal;

    @Column(name = "fecha_alta", nullable = false, length = 10)
    private String fechaAlta;

    @Column(name = "fecha_baja", nullable = true, length = 10)
    private String fechaBaja;

    @Column(name = "email_centro", nullable = true, length = 100)
    private String emailCentro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_familia")
    private Familia familia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "id_estado",
            foreignKey = @ForeignKey(name = "fk_alumno_estado")
    )
    private Estado estado;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "alumno_modulo",
            joinColumns = @JoinColumn(name = "id_alumno"),
            inverseJoinColumns = @JoinColumn(name = "id_modulo")
    )
    private Set<Modulo> modulos = new HashSet<>();

    public Alumno() {
    }

    public Alumno(Long idAlumno, String nombre, String apellido, String dni, String numeroSS, String emailPersonal, String telefonoPersonal, String fechaAlta, String fechaBaja, String emailCentro) {
        this.idAlumno = idAlumno;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.numeroSS = numeroSS;
        this.emailPersonal = emailPersonal;
        this.telefonoPersonal = telefonoPersonal;
        this.fechaAlta = fechaAlta;
        this.fechaBaja = fechaBaja;
        this.emailCentro = emailCentro;
    }

    public Long getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Long idAlumno) {
        this.idAlumno = idAlumno;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNumeroSS() {
        return numeroSS;
    }

    public void setNumeroSS(String numeroSS) {
        this.numeroSS = numeroSS;
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

    public String getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(String fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public String getEmailCentro() {
        return emailCentro;
    }

    public void setEmailCentro(String emailCentro) {
        this.emailCentro = emailCentro;
    }

    public Familia getFamilia() {
        return familia;
    }

    public void setFamilia(Familia familia) {
        this.familia = familia;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Set<Modulo> getModulos() {
        return modulos;
    }

    public void setModulos(Set<Modulo> modulos) {
        this.modulos = modulos;
    }
}