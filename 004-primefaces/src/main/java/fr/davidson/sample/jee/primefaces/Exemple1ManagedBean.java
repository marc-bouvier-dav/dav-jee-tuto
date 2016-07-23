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
 *
 * @author marc
 */
@ManagedBean
@RequestScoped
public class Exemple1ManagedBean {
    
    private List<Exemple1> list;

    /**
     * Creates a new instance of Exemple1ManagedBean
     */
    public Exemple1ManagedBean() {
        list = new ArrayList<>();
   list.add(newExemple1(BigDecimal.ZERO, new Date(), 124L, "lol"));
   list.add(newExemple1(new BigDecimal("100000000000000"), new Date(), 123L, "lol 2"));
        list.add(newExemple1(BigDecimal.ONE, new Date(), 243L, "lol 3"));
    }

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
