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
package fr.davidson.sample.jee.jsf.composants;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


/**
 *
 * @author marc.bouvier@davidson.fr
 */
@ManagedBean(name = "iterationManagedBean")
@ViewScoped
public class IterationManagedBean {
    
List<CleValeur> liste;
CleValeur entreeSelectionnee;
Set<CleValeur> entreesSelectionnees;


@PostConstruct
public void init(){
    liste = new ArrayList<>();
    
    liste.add(newCleValeur("cle1", "valeur 1"));
    liste.add(newCleValeur("cle2", "valeur 2"));
    liste.add(newCleValeur("cle3", "valeur 3"));
}

    private CleValeur newCleValeur(String cle, String valeur) {
        final CleValeur cleValeur = new CleValeur();
        cleValeur.setCle(cle);
        cleValeur.setValeur(valeur);
        return cleValeur;
    }

    public List<CleValeur> getListe() {
        return liste;
    }

    public void setListe(List<CleValeur> liste) {
        this.liste = liste;
    }

    public CleValeur getEntreeSelectionnee() {
        return entreeSelectionnee;
    }

    public void setEntreeSelectionnee(CleValeur entreeSelectionnee) {
        this.entreeSelectionnee = entreeSelectionnee;
    }

    public Set<CleValeur> getEntreesSelectionnees() {
        return entreesSelectionnees;
    }

    public void setEntreesSelectionnees(Set<CleValeur> entreesSelectionnees) {
        this.entreesSelectionnees = entreesSelectionnees;
    }
    
    
    
    

    
    

    
}
