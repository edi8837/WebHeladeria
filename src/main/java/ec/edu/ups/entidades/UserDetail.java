/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

/**
 *
 * @author Jonny,Daniel,Elvis,Edisson
 */
@Entity
public class UserDetail {

    @Id
    @GeneratedValue
    private int id;
    private String detail;
    @OneToOne
    @JoinColumn
    private User user;

    public UserDetail(String detail, User user) {
        this.setDetail(detail);
        this.setUser(user);
    }

    public UserDetail() {
        this("", null);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        String u = ", user=(null)";
        if (this.user != null) {
            u = ", userID=(" + this.user.getId() + ")";
        }
        return "UserDetail [id=" + id + ", detail=" + detail + u + "]";
    }

}
