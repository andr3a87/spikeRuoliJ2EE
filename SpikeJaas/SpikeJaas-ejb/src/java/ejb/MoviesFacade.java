/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Andr3A
 */
@Stateless
public class MoviesFacade extends AbstractFacade<Movies> implements MoviesFacadeLocal {
    @PersistenceContext(unitName = "SpikeJaas-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MoviesFacade() {
        super(Movies.class);
    }
    
}
