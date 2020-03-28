package com.uatx.inventarios.model;

import javax.persistence.*;

@Entity
@Table(name = "productos")
@SequenceGenerator(name="producto_seq")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "producto_seq")
    private Long id;

    @Column(name = "nombre", length = 50)
    private String nombre;


    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
