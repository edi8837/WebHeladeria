/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.beans;



import ec.edu.ups.entidades.EntidadPrincipal;
import ec.edu.ups.entidades.Sucursal;
import ec.edu.ups.entidades.Usuario;
import ec.edu.ups.facade.ClienteFacade;
import ec.edu.ups.facade.SucursalFacade;
import ec.edu.ups.facade.UsuarioFacade;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.enterprise.inject.Model;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Named;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author Jonny,Daniel,Elvis,Edisson
 */
@Named
@SessionScoped
public class SucursalBeans implements Serializable {

    @EJB
    private SucursalFacade sFacade;

    private List<Sucursal> list = new ArrayList<>();
 private int id;
    private String telefono;
    private String direccion;
    private String ciudad;
    private String correo;
   
    @PostConstruct
    public void init() {
        list = sFacade.findAll();
    }

    public String add() {
        sFacade.create(new Sucursal(id, telefono,direccion,ciudad,correo));
        list = sFacade.findAll();
        return null;
    }

    public String delete(Sucursal u) {
        sFacade.remove(u);
        list = sFacade.findAll();
        return null;
    }

    public String edit( Sucursal u) {
        u.setEditable(true);
        return null;
    }

    public String save(Sucursal u) {
        sFacade.edit(u);
        list = sFacade.findAll();
        u.setEditable(false);
        return null;
    }

    public Sucursal[] getList() {
        return list.toArray(new Sucursal[0]);
    }

    public void setList(List<Sucursal> list) {
        this.list = list;
    }

    

    public SucursalFacade getsFacade() {
        return sFacade;
    }

    public void setsFacade(SucursalFacade sFacade) {
        this.sFacade = sFacade;
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

   
}
