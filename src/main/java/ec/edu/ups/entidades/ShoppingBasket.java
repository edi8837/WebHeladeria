/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.entidades;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Gabus
 */
@Entity
public class ShoppingBasket implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    private int id;
    @Temporal(TemporalType.DATE)
    private java.util.Calendar fecha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shoppingBasket")
    private Set<Product> products = new HashSet<Product>();

    public ShoppingBasket() {
        super();
    }

    public ShoppingBasket(int id, Calendar fecha) {
        super();
        this.id = id;
        this.fecha = fecha;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public java.util.Calendar getFecha() {
        return this.fecha;
    }

    public void setFecha(java.util.Calendar fecha) {
        this.fecha = fecha;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void addProducts(Product product) {
        this.products.add(product);
    }

    public void removeProduct(Product product) {
        this.products.remove(product);
    }
}
