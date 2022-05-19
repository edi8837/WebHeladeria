/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.entidades;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Jonny,Daniel,Elvis,Edisson
 */
@Entity
@NamedQuery(name = "getSucursal", query = "SELECT s FROM  Sucursal s")
public class Sucursal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String telefono;
    private String direccion;
    private String ciudad;
    private String correo;
    @ManyToOne
    @JoinColumn(nullable = true)
    private EntidadPrincipal entidadPrincipal;
    @Transient
    private boolean editable;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sucursal")
    private Set<Producto> productos = new HashSet<Producto>();

    public Sucursal() {
        super();
    }

    public Sucursal(int id, String telefono, String direccion, String ciudad, String correo) {
        super();
        this.setId(id);
        this.setTelefono(telefono); 
        this.setDireccion(direccion);
        this.setCiudad(ciudad);
        this.setCorreo(correo); 
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public EntidadPrincipal getEntidadPrincipal() {
        return entidadPrincipal;
    }

    public void setEntidadPrincipal(EntidadPrincipal entidadPrincipal) {
        this.entidadPrincipal = entidadPrincipal;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public Set<Producto> getProductos() {
        return productos;
    }

    public void setProductos(Set<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return "Sucursal{" + "id=" + id + ", telefono=" + telefono + ", direccion=" + direccion + ", ciudad=" + ciudad + ", correo=" + correo + ", entidadPrincipal=" + entidadPrincipal + ", productos=" + productos + '}';
    }
    
}
