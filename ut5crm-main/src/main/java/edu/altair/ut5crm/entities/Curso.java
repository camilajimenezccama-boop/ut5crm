package edu.altair.ut5crm.entities;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cursos")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso")
    private Long idCurso;

    @Column(name = "diminutivo", nullable = false, unique = true, length = 9)
    private String diminutivo;

    @Column(name = "descripcion", length = 500)
    private String descripcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "id_titulacion",
            foreignKey = @ForeignKey(name = "fk_curso_titulacion")
    )
    private Titulacion titulacion;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "curso_modulo",
            joinColumns = @JoinColumn(name = "id_curso"),
            inverseJoinColumns = @JoinColumn(name = "id_modulo")
    )
    private Set<Modulo> modulos = new HashSet<>();

    public Curso() {
    }

    public Curso(Long idCurso, String diminutivo, String descripcion) {
        this.idCurso = idCurso;
        this.diminutivo = diminutivo;
        this.descripcion = descripcion;
    }

    public Long getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Long idCurso) {
        this.idCurso = idCurso;
    }

    public String getDiminutivo() {
        return diminutivo;
    }

    public void setDiminutivo(String diminutivo) {
        this.diminutivo = diminutivo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Titulacion getTitulacion() {
        return titulacion;
    }

    public void setTitulacion(Titulacion titulacion) {
        this.titulacion = titulacion;
    }

    public Set<Modulo> getModulos() {
        return modulos;
    }

    public void setModulos(Set<Modulo> modulos) {
        this.modulos = modulos;
    }
}