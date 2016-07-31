package fr.davidson.sample.jee.web;

import fr.davidson.sample.jee.domain.model.formation.Formateur;
import fr.davidson.sample.jee.domain.service.FormateurFacadeLocal;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;


@ManagedBean
@RequestScoped
public class Exemple1ManagedBean {

@Inject 
private FormateurFacadeLocal formateurService;

List<Formateur> list;

    public List<Formateur> getList() {
        return list;
    }

    public void setList(List<Formateur> list) {
        this.list = list;
    }



}
