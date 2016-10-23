/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.davidson.sample.jee.jsf.composants;

/**
 *
 * @author marc
 */
public enum ExempleEnum {
    EXEMPLE1("exemple 1"),EXEMPLE2("exemple 2"),EXEMPLE3("exemple 3");
    
    private final String label;

    private ExempleEnum(String label) {
        this.label = label;
    }
    
}
