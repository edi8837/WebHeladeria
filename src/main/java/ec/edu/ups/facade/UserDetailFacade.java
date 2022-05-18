/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.facade;

import ec.edu.ups.entidades.User;
import ec.edu.ups.entidades.UserDetail;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author Gabus
 */
@Stateless
public class UserDetailFacade extends AbstractFacade<UserDetail>{
    
    @PersistenceContext(name = "TestJpa")
    private EntityManager em;

    public UserDetailFacade() {
        super(UserDetail.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
