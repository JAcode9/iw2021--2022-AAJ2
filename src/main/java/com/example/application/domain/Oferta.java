package com.example.application.domain;

import javax.persistence.*;

@Entity
public class Oferta {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_oferta;
    private String numero;
    private String url;
    private String precio;
    private String descripcion;
    private boolean activa;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ofertacine")
    private Cine cine_of;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    public Cine getCine_of() {
        return cine_of;
    }

    public void setCine_of(Cine cine_of) {
        this.cine_of = cine_of;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId_oferta() {
        return id_oferta;
    }

    public void setId_oferta(int id_oferta) {
        this.id_oferta = id_oferta;
    }
}
