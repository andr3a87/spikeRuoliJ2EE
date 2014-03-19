/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Andr3A
 */
@Entity
public class Movies implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;    
    private String regista;    
    private String titolo;    
    private int anno;

    /**
     * Get the value of anno
     *
     * @return the value of anno
     */
    public int getAnno() {
        return anno;
    }

    /**
     * Set the value of anno
     *
     * @param anno new value of anno
     */
    public void setAnno(int anno) {
        this.anno = anno;
    }

    /**
     * Get the value of titolo
     *
     * @return the value of titolo
     */
    public String getTitolo() {
        return titolo;
    }

    /**
     * Set the value of titolo
     *
     * @param titolo new value of titolo
     */
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    /**
     * Get the value of regista
     *
     * @return the value of regista
     */
    public String getRegista() {
        return regista;
    }

    /**
     * Set the value of regista
     *
     * @param regista new value of regista
     */
    public void setRegista(String regista) {
        this.regista = regista;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movies)) {
            return false;
        }
        Movies other = (Movies) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.Movies[ id=" + id + " ]";
    }
    
}
