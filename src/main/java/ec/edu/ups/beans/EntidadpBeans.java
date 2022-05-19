/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.beans;



import ec.edu.ups.entidades.EntidadPrincipal;
import ec.edu.ups.entidades.Sucursal;
import ec.edu.ups.entidades.Usuario;
import ec.edu.ups.facade.ClienteFacade;
import ec.edu.ups.facade.EntidadpFacade;
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
public class EntidadpBeans implements Serializable {

    @EJB
    private EntidadpFacade epFacade;

    private List<EntidadPrincipal> list = new ArrayList<>();
   private int id;
    private String nombre;
    private String ruc;
    private String telefono;
    private String direccion;
   
    @PostConstruct
    public void init() {
        list = epFacade.findAll();
    }

    public String add() {
        epFacade.create(new EntidadPrincipal(id, nombre,ruc,telefono,direccion));
        list = epFacade.findAll();
        return null;
    }

    public String delete(EntidadPrincipal u) {
        epFacade.remove(u);
        list = epFacade.findAll();
        return null;
    }

    public String edit(EntidadPrincipal u) {
        u.setEditable(true);
        return null;
    }

    public String save(EntidadPrincipal u) {
        epFacade.edit(u);
        list = epFacade.findAll();
        u.setEditable(false);
        return null;
    }

    public EntidadPrincipal[] getList() {
        return list.toArray(new EntidadPrincipal[0]);
    }

    public void setList(List<EntidadPrincipal> list) {
        this.list = list;
    }

    

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EntidadpFacade getEpFacade() {
        return epFacade;
    }

    public void setEpFacade(EntidadpFacade epFacade) {
        this.epFacade = epFacade;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
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


   
}
