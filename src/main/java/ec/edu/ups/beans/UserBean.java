/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.beans;

import ec.edu.ups.entidades.User;
import ec.edu.ups.facade.UserFacade;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jonny,Daniel,Elvis,Edisson
 */
@Named
@SessionScoped
public class UserBean implements Serializable {
     private static final long serialVersionUID = 1L;
     
     @EJB
     private UserFacade userFacade;     
     private List<User> list = new ArrayList<>();
     private int id;
     private String name;
     private String password;
     private int level;

    @PostConstruct
    public void init() {	
	list = userFacade.findAll();
    }
    
    public String add() {	
        userFacade.create(new User(id, name, password, level));
        list = userFacade.findAll();
	return null;
    }

    public String delete(User u) {
	userFacade.remove(u);
        list = userFacade.findAll();
	return null;
    }

    public String edit(User u) {
	u.setEditable(true);
	return null;
    }

    public String save(User u) {
        userFacade.edit(u);
        list = userFacade.findAll();
	u.setEditable(false);
	return null;
    }

    public User[] getList() {
	return list.toArray(new User[0]);
    }

    public void setList(List<User> list) {
	this.list = list;
    }

    public UserFacade getUserFacade() {
        return userFacade;
    }

    public void setUserFacade(UserFacade userFacade) {
        this.userFacade = userFacade;
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
    
    
     
    
}
