/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import java.io.Serializable;

/**
 *
 * @author Jonny
 */
@Entity
@NamedQuery(name = "getProducto", query = "SELECT p FROM  Producto p")
class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nombre;
    private String descripcion;
    private String marca;
    private int stock;
    private String estado;
    private Double precio;

    @ManyToOne
    @JoinColumn(nullable = true)
    private Pedido pedido;
    @ManyToOne
    @JoinColumn(nullable = true)
    private Sucursal sucursal;
}
