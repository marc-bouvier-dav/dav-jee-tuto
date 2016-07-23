/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.davidson.sample.jee.primefaces;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Classe comportant des champs de types différents afin de montrer leur prise
 * en compte au niveau de la vue JSF.
 *
 * @author Marc Bouvier
 */
public class Exemple1 {

    private String label;
    private Date date;
    private Long entierLong;
    private BigDecimal decimal;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getEntierLong() {
        return entierLong;
    }

    public void setEntierLong(Long entierLong) {
        this.entierLong = entierLong;
    }

    public BigDecimal getDecimal() {
        return decimal;
    }

    public void setDecimal(BigDecimal decimal) {
        this.decimal = decimal;
    }

}
