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
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Jonny
 */
@Entity
@NamedQuery(name = "getSucursal", query = "SELECT s FROM  Sucursal s")
class Sucursal implements Serializable {

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
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sucursal")
    private Set<Producto> productos = new HashSet<Producto>();

}
