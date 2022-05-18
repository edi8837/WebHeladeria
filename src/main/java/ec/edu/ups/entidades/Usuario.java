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
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Jonny
 */
@Entity
@NamedQuery(name = "getUsuario", query = "SELECT u FROM  Usuario u")

class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String cedula;
    private String nombre;
    private String apellido;
    private String correo;
    private String contrasenia;
    private String tipoUs;
    private String telefono;
    private String direccion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private Set<FacturaCabecera> facturaCabecera = new HashSet<FacturaCabecera>();
    @Transient
    private boolean editable;
}
