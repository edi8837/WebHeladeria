/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.entidades;

import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;

/**
 *
 * @author Jonny,Daniel,Elvis,Edisson
 */
@NamedQuery(name = "getByLevel", 
            query = "SELECT u FROM User u WHERE u.level >= :level")
@Entity
public class User {

    @Id    
    private int id;
    private String name;
    private String password;
    private int level;
    @Transient
    private boolean editable;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    private UserDetail detail;

    public User(int id, String name, String password) {
        this.setId(id);
        this.setName(name);
        this.setPassword(password);
        this.setLevel(1);
    }

    public User(int id, String name, String password, int level) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.level = level;
    }
    
    

    public User() {
        this(0, "", "");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public UserDetail getDetail() {
        return this.detail;
    }

    public void setDetail(UserDetail detail) {
        this.detail = detail;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }        

    @Override
    public String toString() {
        String d = ", detail=(null)";
        if (this.detail != null) {
            d = ", detail=(" + this.detail.toString() + ")";
        }
        return "User [id=" + id + ", name=" + name + ", password=" + password + 
                ", level=" + level + d + "]";
    }
}
