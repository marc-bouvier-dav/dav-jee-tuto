/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.davidson.sample.jee.primefaces;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * Bean managé permettant de retourner les informations de la liste affichée
 * dans l'exemple 1 (exemple1.xhtml)
 * <p>
 * Cet objet a une portée limitée à la requête : @{@link RequestScoped}</p>
 *
 * @author Marc Bouvier
 */
@ManagedBean
@RequestScoped
public class Exemple1ManagedBean {

    /**
     * Liste d'objet de type Exemple1
     * <p>Cet objet comporte des champs de types différents</p>
     * <p>Primefaces est capable de convertir un certain nombre de types java
     * nativement pour les rendre lisible à l'écran</p>
     * <p>Il est possible d'écrire des convertisseurs pour les types non 
     * supportés ou pour afficher/saisir des données de façon personnalisée</p>
     * </p>
     */
    private List<Exemple1> list;

    /**
     * Construciton du bean.
     * <p>
     * Alimentation de la liste avec des données 
     * </p>
     * 
     */
    public Exemple1ManagedBean() {
        list = new ArrayList<>();
        list.add(newExemple1(BigDecimal.ZERO, new Date(), 124L, "lol"));
        list.add(newExemple1(new BigDecimal("100000000000000"), new Date(), 123L, "lol 2"));
        list.add(newExemple1(BigDecimal.ONE, new Date(), 243L, "lol 3"));
    }

    /**
     * Mérhode utilitaire permettant de faciliter la créatio d'un objet Exempl1.
     * @param ZERO
     * @param date
     * @param name
     * @param lol
     * @return nouvelle d'instance de Exemple1
     */
    private Exemple1 newExemple1(final BigDecimal ZERO, final Date date, final long name, final String lol) {
        Exemple1 item1 = new Exemple1();
        item1.setDecimal(ZERO);
        item1.setDate(date);
        item1.setEntierLong(name);
        item1.setLabel(lol);
        return item1;
    }

    public List<Exemple1> getList() {
        return list;
    }

    public void setList(List<Exemple1> list) {
        this.list = list;
    }

}
