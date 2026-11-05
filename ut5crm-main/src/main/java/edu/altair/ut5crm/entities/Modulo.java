package edu.altair.ut5crm.entities;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "modulos")
public class Modulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_modulo")
    private Long idModulo;

    @Column(name = "codigo", nullable = false, unique = true, length = 9)
    private String codigo;

    @Column(name = "diminutivo", nullable = false, unique = true, length = 9)
    private String diminutivo;

    @Column(name = "nombre", nullable = false, length = 20)
    private String nombre;

    @Column(name = "descripcion", length = 200)
    private String descripcion;

    @Column(name = "horas_semanales")
    private Long horasSemanales;

    @Column(name = "creditos")
    private Long creditos;

    @ManyToMany(mappedBy = "modulos", fetch = FetchType.LAZY)
    private Set<Alumno> alumnos = new HashSet<>();

    @ManyToMany(mappedBy = "modulos", fetch = FetchType.LAZY)
    private Set<Profesor> profesores = new HashSet<>();

    @ManyToMany(mappedBy = "modulos", fetch = FetchType.LAZY)
    private Set<Curso> cursos = new HashSet<>();

    public Modulo() {
    }

    public Modulo(Long idModulo, String codigo, String diminutivo, String nombre, String descripcion, Long horasSemanales, Long creditos) {
        this.idModulo = idModulo;
        this.codigo = codigo;
        this.diminutivo = diminutivo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.horasSemanales = horasSemanales;
        this.creditos = creditos;
    }

    public Long getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(Long idModulo) {
        this.idModulo = idModulo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDiminutivo() {
        return diminutivo;
    }

    public void setDiminutivo(String diminutivo) {
        this.diminutivo = diminutivo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getHorasSemanales() {
        return horasSemanales;
    }

    public void setHorasSemanales(Long horasSemanales) {
        this.horasSemanales = horasSemanales;
    }

    public Long getCreditos() {
        return creditos;
    }

    public void setCreditos(Long creditos) {
        this.creditos = creditos;
    }

    public Set<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Set<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public Set<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(Set<Profesor> profesores) {
        this.profesores = profesores;
    }

    public Set<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(Set<Curso> cursos) {
        this.cursos = cursos;
    }
}