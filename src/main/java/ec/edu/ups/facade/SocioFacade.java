/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.facade;

import ec.edu.ups.entidades.ShoppingBasket;
import ec.edu.ups.entidades.Socio;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author Jonny,Daniel,Elvis,Edisson
 */
@Stateless
public class SocioFacade extends AbstractFacade<Socio>{
    
    @PersistenceContext(name = "TestJpa")
    private EntityManager em;

    public SocioFacade() {
        super(Socio.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
