/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.facade;

import ec.edu.ups.entidades.Product;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author Gabus
 */
@Stateless
public class ProductFacade extends AbstractFacade<Product>{
    
    @PersistenceContext(name = "TestJpa")
    private EntityManager em;

    public ProductFacade() {
        super(Product.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
