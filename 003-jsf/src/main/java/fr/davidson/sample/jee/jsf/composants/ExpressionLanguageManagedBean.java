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
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.el.ELContextEvent;
import javax.el.ELContextListener;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author osboxes
 */
@ManagedBean(name = "expressionLanguageManagedBean")
@ViewScoped
public class ExpressionLanguageManagedBean {

    String chaineVide = "";
    String chaineNull = null;
    List<String> collectionVide = new ArrayList<>();
    Integer entier1;
    Integer entier2;
    Boolean souligner;
    Boolean check1;
    Boolean check2;
    String chaine;
    Map<String, String> mapPourIteration;
    

    public ExpressionLanguageManagedBean() {
        entier1 = 1;
        entier2 = 1;
        check1 = false;
        check2 = false;
        mapPourIteration = new HashMap<>();
        mapPourIteration.put("clé1", "Valeur1");
        mapPourIteration.put("clé2", "Valeur2");
        mapPourIteration.put("clé3", "Valeur3");

    }

    public static String methodeStatique() {
        return "valeurMethodeStatique";
    }

    ;

    public String getChaineVide() {
        return chaineVide;
    }

    public String getChaineNull() {
        return chaineNull;
    }

    public List<String> getCollectionVide() {
        return collectionVide;
    }

    public Integer getEntier1() {
        return entier1;
    }

    public void setEntier1(Integer entier1) {
        this.entier1 = entier1;
    }

    public Integer getEntier2() {
        return entier2;
    }

    public void setEntier2(Integer entier2) {
        this.entier2 = entier2;
    }

    public Boolean getSouligner() {
        return souligner;
    }

    public void setSouligner(Boolean souligner) {
        this.souligner = souligner;
    }

    public Boolean getCheck1() {
        return check1;
    }

    public void setCheck1(Boolean check1) {
        this.check1 = check1;
    }

    public Boolean getCheck2() {
        return check2;
    }

    public void setCheck2(Boolean check2) {
        this.check2 = check2;
    }

    public String getChaine() {
        return chaine;
    }

    public void setChaine(String chaine) {
        this.chaine = chaine;
    }

    public Map<String, String> getMapPourIteration() {
        return mapPourIteration;
    }

    public void setMapPourIteration(Map<String, String> mapPourIteration) {
        this.mapPourIteration = mapPourIteration;
    }

}
