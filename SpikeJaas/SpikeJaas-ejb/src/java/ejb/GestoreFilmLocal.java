/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Andr3A
 */
@Local
public interface GestoreFilmLocal {

    void addMovie(String regista, String titolo, int anno);

    void deleteMovie(Movies movie);

    List<Movies> findMovies();
    
}
