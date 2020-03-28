package com.uatx.inventarios.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "productos")
@SequenceGenerator(name="producto_seq")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "producto_seq")
    private Long id;

    @Column(name = "nombre", length = 50)
    private String nombre;

    @Column(name = "fechaAlta")
    private Date fecha;


    @Column(name = "stock")
    private Double stock;

    @Column(name = "precio")
    private Double precio;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "id_imagen")
    private Imagen imagen;



    public Long getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {return fecha;}
    public void  setFecha(Date fecha) { this.fecha = fecha;}

    public Double getStock() {return stock;}
    public void  setStock(Double stock) { this.stock = stock;}

    public Double getPrecio() {return precio;}
    public void  setPrecio(Double precio) { this.precio = precio;}

    public Imagen getImagen() {return imagen;}
    public void  setImagen(Imagen imagen) { this.imagen = imagen;}


}

