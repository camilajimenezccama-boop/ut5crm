package edu.altair.ut5crm.entities;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "titulaciones")
public class Titulacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_titulacion")
    private Long idTitulacion;

    @Column(name = "codigo", nullable = false, unique = true, length = 9)
    private String codigo;

    @Column(name = "diminutivo", nullable = false, unique = true, length = 9)
    private String diminutivo;

    @Column(name = "horas_totales", nullable = false)
    private Long horasTotales;

    @OneToMany(mappedBy = "titulacion")
    private List<Curso> cursos = new ArrayList<>();

    public Titulacion() {
    }

    public Titulacion(Long idTitulacion, String codigo, String diminutivo, Long horasTotales) {
        this.idTitulacion = idTitulacion;
        this.codigo = codigo;
        this.diminutivo = diminutivo;
        this.horasTotales = horasTotales;
    }

    public Long getIdTitulacion() {
        return idTitulacion;
    }

    public void setIdTitulacion(Long idTitulacion) {
        this.idTitulacion = idTitulacion;
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

    public Long getHorasTotales() {
        return horasTotales;
    }

    public void setHorasTotales(Long horasTotales) {
        this.horasTotales = horasTotales;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
}