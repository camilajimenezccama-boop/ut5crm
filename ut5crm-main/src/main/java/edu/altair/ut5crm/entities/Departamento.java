package edu.altair.ut5crm.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "departamentos")
public class Departamento {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_departamento")
    private Long idDepartamento;

    @Column(name = "codigo", nullable = false, unique = true, length = 50)
    private String codigo;

    @OneToMany(mappedBy = "departamento")
    private List<Profesor> profesores = new ArrayList<>();

    public Departamento() {
    }

    public Departamento(String codigo, Long idDepartamento) {
        this.codigo = codigo;
        this.idDepartamento = idDepartamento;
    }

    public Long getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Long idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public List<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(List<Profesor> profesores) {
        this.profesores = profesores;
    }
}
