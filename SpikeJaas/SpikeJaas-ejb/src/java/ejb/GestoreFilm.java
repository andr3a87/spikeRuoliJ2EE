/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import java.rmi.RemoteException;
import java.security.Principal;
import java.util.List;
import javax.annotation.Resource;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.EJBContext;
import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

/**
 *
 * @author Andr3A
 */
@Stateless
@DeclareRoles({"administrator"})
public class GestoreFilm implements GestoreFilmLocal{
    @Resource SessionContext context;
    @EJB
    private MoviesFacadeLocal moviesFacade;
    
    @Override
    public void addMovie(String regista, String titolo, int anno) {
        Movies m = new Movies();
        m.setTitolo(titolo);
        m.setRegista(regista);
        m.setAnno(anno);
        Principal principal = context.getCallerPrincipal();     
        String  callerId= principal.getName();
        boolean isManager = context.isCallerInRole("administrator");
        if ( isManager )
            moviesFacade.create(m);
    }
    
    @Override
    public void deleteMovie(Movies movie) {
        // Ottenere il chiamante del bean utilizzando getCallerPrincipal()
        Principal principal = context.getCallerPrincipal();     
        String  callerId= principal.getName();
        
        // Controllare se il chiamante del bean dispone del ruolo Mgr
        boolean isManager = context.isCallerInRole("administrator");

        // Impostare il messaggio fornito solo se il chiamante è "bob" o se dispone del ruolo Mgr
        if ( isManager )
           moviesFacade.remove(movie); 
    }
    
    @PermitAll
    @Override
    public List<Movies> findMovies() {
        return moviesFacade.findAll();
    }

}
