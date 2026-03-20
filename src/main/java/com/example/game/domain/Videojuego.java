/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.game.domain;
import java.math.BigDecimal;
import jakarta.persistence.*;
/**
 *
 * @author samu ospina
 */
@Entity
@Table(name = "videojuego")
public class Videojuego {
    @Id // Esto dice que este campo es la llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Esto hace que el ID sea autoincrementable (1, 2, 3...)
    private Long id;
    
    private String nombre;
    private String descripcion;
    private String imagenUrl;
    private BigDecimal precio;       
    private int descuento;          
    private String plataforma;      
    private double rating;         
    private int stock;
    
    public Videojuego() {}

    public Videojuego(String nombre, String descripcion, String imagenUrl,
                      BigDecimal precio, int descuento, String plataforma, double rating, int stock) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagenUrl = imagenUrl;
        this.precio = precio;
        this.descuento = descuento;
        this.plataforma = plataforma;
        this.rating = rating;
        this.stock = stock;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getImagenUrl() { return imagenUrl; }
    public void setImagenUrl(String imagenUrl) { this.imagenUrl = imagenUrl; }

    public BigDecimal getPrecio() { return precio; }
    public void setPrecio(BigDecimal precio) { this.precio = precio; }

    public int getDescuento() { return descuento; }
    public void setDescuento(int descuento) { this.descuento = descuento; }

    public String getPlataforma() { return plataforma; }
    public void setPlataforma(String plataforma) { this.plataforma = plataforma; }

    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }
    
    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }
    
    public BigDecimal getPrecioConDescuento() {
        if (descuento <= 0) return precio;
        return precio.subtract(precio.multiply(new BigDecimal(descuento)).divide(new BigDecimal(100)));
    }
}
