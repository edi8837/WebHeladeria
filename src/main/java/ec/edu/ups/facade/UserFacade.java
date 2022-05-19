/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.facade;

import ec.edu.ups.entidades.Persona;
import ec.edu.ups.entidades.User;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.List;

/**
 *
 * @author Jonny,Daniel,Elvis,Edisson
 */
@Stateless
public class UserFacade extends AbstractFacade<User>{
    
    @PersistenceContext(name = "TestJpa")
    private EntityManager em;

    public UserFacade() {
        super(User.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public List<Integer> getUsersIds(){
        String jpql = "SELECT u.id FROM User u";
        List<Integer> res = em.createQuery(jpql).getResultList();
        
        return res;
    }
    
    public User getUserById(Integer id){
        String jpql = "SELECT u FROM User u WHERE u.id = " + id;
        User user = (User) em.createQuery(jpql).getSingleResult();
        return user;
    }
    
    public List<User> getUsersByLevel(int level){
        Query query = em.createNamedQuery("getByLevel");
        query.setParameter("level", level);
        
        List<User> res = query.getResultList();
        return res;
    }
    
    public List<User> getUsersByNameAndLevel(String name, int level){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);        
        Root root = cq.from(User.class);
        cq.select(root);
        Predicate p1 = cb.like(root.get("name").as(String.class),name);
        Predicate p2 = cb.greaterThanOrEqualTo(root.get("level").as(Integer.class),level);
        Predicate pf = cb.and(p1, p2);
        cq.where(pf);
        
        Query query = em.createQuery(cq);
        return query.getResultList();
        
        
    }
    
}
