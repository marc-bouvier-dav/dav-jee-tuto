/*
 * This is free and unencumbered software released into the public domain.
 * 
 * Anyone is free to copy, modify, publish, use, compile, sell, or
 * distribute this software, either in source code form or as a compiled
 * binary, for any purpose, commercial or non-commercial, and by any
 * means.
 * 
 * In jurisdictions that recognize copyright laws, the author or authors
 * of this software dedicate any and all copyright interest in the
 * software to the public domain. We make this dedication for the benefit
 * of the public at large and to the detriment of our heirs and
 * successors. We intend this dedication to be an overt act of
 * relinquishment in perpetuity of all present and future rights to this
 * software under copyright law.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS BE LIABLE FOR ANY CLAIM, DAMAGES OR
 * OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 * 
 * For more information, please refer to <http://unlicense.org>
 */
package fr.davidson.sample.jee.jsf;

import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


/**
 * Bean managé par JSF, il est accessible aux facelet via EL
 * <p>
 * Ce bean est en scope Request (@{@link RequestScoped}), cela signifie que l'objet est recréé à chaque
 * requête HTTP de facelet l'utilisant.</p>
 *
 * @author marc.bouvier@davidson.fr
 */
@ManagedBean(name = "managedBean1")
@RequestScoped
public class ManagedBean1 {

    /**
     * Attribut de type date
     */
    private Date dateCourante;
    
    private Integer entier;
    
    private String nom;
    
    

    /**
     * Creates a new instance of ManagedBean1
     */
    public ManagedBean1() {
        dateCourante = new Date();
        entier =1;
    }

    public Date getDateCourante() {
        return dateCourante;
    }

    public void setDateCourante(Date dateCourante) {
        this.dateCourante = dateCourante;
    }

    public Integer getEntier() {
        return entier;
    }

    public void setEntier(Integer entier) {
        this.entier = entier;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    
    
    
}
