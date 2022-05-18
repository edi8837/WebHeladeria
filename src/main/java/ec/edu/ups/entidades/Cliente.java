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
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/**
 *
 * @author Jonny
 */
@NamedQuery(name = "getCliente", query = "SELECT u FROM  Cliente u")
@Entity

public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String cedula;
    private String nombre;
    private String apellido;
    private String correo;
    private String contrasenia;
    @Temporal(TemporalType.DATE)
    private GregorianCalendar fechaNacimiento;
    private String telefono;
    private String direccion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private Set<Pedido> pedidos = new HashSet<Pedido>();
    
   @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private Set<Tarjeta> tarjeta = new HashSet<Tarjeta>();

    @Transient
    private boolean editable;

    public Cliente() {
        super();

    }

    public Cliente(int id, String cedula, String nombre, String apellido, String correo, String contrasenia, GregorianCalendar fechaNacimiento, String telefono, String direccion) {
        super();
        this.setId(id);
        this.setCedula(cedula);
        this.setNombre(nombre); 
        this.setApellido(apellido);
        this.setCorreo(correo); 
        this.setContrasenia(contrasenia);
        this.setFechaNacimiento(new GregorianCalendar(Locale.ITALY));
        this.setTelefono(telefono); 
        this.setDireccion(direccion);
    }   

    public Cliente(int id, String cedula, String nombre, String apellido, String correo, GregorianCalendar fechaNacimiento, String telefono, String direccion) {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.direccion = direccion;
    }
    
    
    
    
    public int getId() {
        return id;
    }
    

    public void setId(int id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public GregorianCalendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(GregorianCalendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
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

    public Set<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(Set<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public Set<Tarjeta> getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Set<Tarjeta> tarjeta) {
        this.tarjeta = tarjeta;
    }
    

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", correo=" + correo + ", contrasenia=" + contrasenia + ", fechaNacimiento=" + fechaNacimiento + ", telefono=" + telefono + ", direccion=" + direccion + ", pedidos=" + pedidos + ", tarjeta=" + tarjeta + '}';
    }

    

}
