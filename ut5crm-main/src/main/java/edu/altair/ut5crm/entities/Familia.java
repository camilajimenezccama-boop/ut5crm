package edu.altair.ut5crm.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "familias")
public class Familia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_familia")
    private Long idFamilia;

    @Column(name = "nombre_madre", nullable = false, length = 100)
    private String nombreMadre;

    @Column(name = "nombre_padre", nullable = false, length = 100)
    private String nombrePadre;

    @Column(name = "apellidos_madre", nullable = false, length = 100)
    private String apellidoMadre;

    @Column(name = "apellidos_padre", nullable = false, length = 100)
    private String apellidoPadre;

    @Column(name = "email_padre", length = 254)
    private String emailPadre;

    @Column(name = "email_madre", length = 254)
    private String emailMadre;

    @Column(name = "telefono_madre", length = 9)
    private String telefonoMadre;

    @Column(name = "telefono_padre", length = 9)
    private String telefonoPadre;

    @Column(name = "direccion_padre", length = 200)
    private String direccionPadre;

    @Column(name = "direccion_madre", length = 200)
    private String direccionMadre;

    @Column(name = "cp_madre")
    private Long cpMadre;

    @Column(name = "cp_padre")
    private Long cpPadre;

    @Column(name = "municipio_madre", length = 100)
    private String municipioMadre;

    @Column(name = "municipio_padre", length = 100)
    private String municipioPadre;

    @Column(name = "provincia_madre", length = 100)
    private String provinciaMadre;

    @Column(name = "provincia_padre", length = 100)
    private String provinciaPadre;

    @Column(name = "son_separados")
    private Boolean sonSeparados;

    @Column(name = "es_compartida")
    private Boolean esCompartida;

    @Column(name = "es_padre")
    private Boolean esPadre;

    @Column(name = "es_madre")
    private Boolean esMadre;

    @OneToMany(mappedBy = "familia")
    private List<Alumno> alumnos;

    public Familia() {
    }

    public Familia(Long idFamilia, String nombreMadre, String nombrePadre, String apellidoMadre, String apellidoPadre, String emailPadre, String emailMadre, String telefonoMadre, String telefonoPadre, String direccionPadre, String direccionMadre, Long cpMadre, Long cpPadre, String municipioMadre, String municipioPadre, String provinciaMadre, String provinciaPadre, Boolean sonSeparados, Boolean esCompartida, Boolean esPadre, Boolean esMadre) {
        this.idFamilia = idFamilia;
        this.nombreMadre = nombreMadre;
        this.nombrePadre = nombrePadre;
        this.apellidoMadre = apellidoMadre;
        this.apellidoPadre = apellidoPadre;
        this.emailPadre = emailPadre;
        this.emailMadre = emailMadre;
        this.telefonoMadre = telefonoMadre;
        this.telefonoPadre = telefonoPadre;
        this.direccionPadre = direccionPadre;
        this.direccionMadre = direccionMadre;
        this.cpMadre = cpMadre;
        this.cpPadre = cpPadre;
        this.municipioMadre = municipioMadre;
        this.municipioPadre = municipioPadre;
        this.provinciaMadre = provinciaMadre;
        this.provinciaPadre = provinciaPadre;
        this.sonSeparados = sonSeparados;
        this.esCompartida = esCompartida;
        this.esPadre = esPadre;
        this.esMadre = esMadre;
    }

    public Long getIdFamilia() {
        return idFamilia;
    }

    public void setIdFamilia(Long idFamilia) {
        this.idFamilia = idFamilia;
    }

    public String getNombreMadre() {
        return nombreMadre;
    }

    public void setNombreMadre(String nombreMadre) {
        this.nombreMadre = nombreMadre;
    }

    public String getNombrePadre() {
        return nombrePadre;
    }

    public void setNombrePadre(String nombrePadre) {
        this.nombrePadre = nombrePadre;
    }

    public String getApellidoMadre() {
        return apellidoMadre;
    }

    public void setApellidoMadre(String apellidoMadre) {
        this.apellidoMadre = apellidoMadre;
    }

    public String getApellidoPadre() {
        return apellidoPadre;
    }

    public void setApellidoPadre(String apellidoPadre) {
        this.apellidoPadre = apellidoPadre;
    }

    public String getEmailPadre() {
        return emailPadre;
    }

    public void setEmailPadre(String emailPadre) {
        this.emailPadre = emailPadre;
    }

    public String getEmailMadre() {
        return emailMadre;
    }

    public void setEmailMadre(String emailMadre) {
        this.emailMadre = emailMadre;
    }

    public String getTelefonoMadre() {
        return telefonoMadre;
    }

    public void setTelefonoMadre(String telefonoMadre) {
        this.telefonoMadre = telefonoMadre;
    }

    public String getTelefonoPadre() {
        return telefonoPadre;
    }

    public void setTelefonoPadre(String telefonoPadre) {
        this.telefonoPadre = telefonoPadre;
    }

    public String getDireccionPadre() {
        return direccionPadre;
    }

    public void setDireccionPadre(String direccionPadre) {
        this.direccionPadre = direccionPadre;
    }

    public String getDireccionMadre() {
        return direccionMadre;
    }

    public void setDireccionMadre(String direccionMadre) {
        this.direccionMadre = direccionMadre;
    }

    public Long getCpMadre() {
        return cpMadre;
    }

    public void setCpMadre(Long cpMadre) {
        this.cpMadre = cpMadre;
    }

    public Long getCpPadre() {
        return cpPadre;
    }

    public void setCpPadre(Long cpPadre) {
        this.cpPadre = cpPadre;
    }

    public String getMunicipioMadre() {
        return municipioMadre;
    }

    public void setMunicipioMadre(String municipioMadre) {
        this.municipioMadre = municipioMadre;
    }

    public String getMunicipioPadre() {
        return municipioPadre;
    }

    public void setMunicipioPadre(String municipioPadre) {
        this.municipioPadre = municipioPadre;
    }

    public String getProvinciaMadre() {
        return provinciaMadre;
    }

    public void setProvinciaMadre(String provinciaMadre) {
        this.provinciaMadre = provinciaMadre;
    }

    public String getProvinciaPadre() {
        return provinciaPadre;
    }

    public void setProvinciaPadre(String provinciaPadre) {
        this.provinciaPadre = provinciaPadre;
    }

    public Boolean getSonSeparados() {
        return sonSeparados;
    }

    public void setSonSeparados(Boolean sonSeparados) {
        this.sonSeparados = sonSeparados;
    }

    public Boolean getEsCompartida() {
        return esCompartida;
    }

    public void setEsCompartida(Boolean esCompartida) {
        this.esCompartida = esCompartida;
    }

    public Boolean getEsPadre() {
        return esPadre;
    }

    public void setEsPadre(Boolean esPadre) {
        this.esPadre = esPadre;
    }

    public Boolean getEsMadre() {
        return esMadre;
    }

    public void setEsMadre(Boolean esMadre) {
        this.esMadre = esMadre;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
}