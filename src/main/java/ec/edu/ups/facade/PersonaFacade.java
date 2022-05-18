/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.facade;

import ec.edu.ups.entidades.Persona;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author Gabus
 */
@Stateless
public class PersonaFacade extends AbstractFacade<Persona>{
    
    @PersistenceContext(name = "TestJpa")
    private EntityManager em;

    public PersonaFacade() {
        super(Persona.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
