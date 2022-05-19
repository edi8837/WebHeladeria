/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ec.edu.ups.beans;

import ec.edu.ups.entidades.Producto;
import ec.edu.ups.facade.ProductoFacade;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Elvis
 */
@Named
@SessionScoped
public class ProductoBeans implements Serializable {

    @EJB
    private ProductoFacade producFacade;
    
    private List<Producto> list = new ArrayList<>();
    private int id;
    private String nombre;
    private String descripcion;
    private String marca;
    private int stock;
    private String estado;
    private Double precio;
    
    @PostConstruct
    public void init() {
        list = producFacade.findAll();
    }
    
    public String add() {
        producFacade.create(new Producto(id, nombre, descripcion, marca, stock, estado, precio));
        list = producFacade.findAll();
        return null;
    }

    public String delete(Producto u) {
        producFacade.remove(u);
        list = producFacade.findAll();
        return null;
    }

    public String edit( Producto u) {
        u.setEditable(true);
        return null;
    }

    public String save(Producto u) {
        producFacade.edit(u);
        list = producFacade.findAll();
        u.setEditable(false);
        return null;
    }
    
    public Producto[] getList() {
        return list.toArray(new Producto[0]);
    }

    public void setList(List<Producto> list) {
        this.list = list;
    }

    public ProductoFacade getProducFacade() {
        return producFacade;
    }

    public void setProducFacade(ProductoFacade producFacade) {
        this.producFacade = producFacade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    
    
}
