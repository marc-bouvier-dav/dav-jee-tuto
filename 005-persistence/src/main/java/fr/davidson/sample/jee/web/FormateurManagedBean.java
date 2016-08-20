package fr.davidson.sample.jee.web;

import fr.davidson.sample.jee.domain.model.formation.Formateur;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import fr.davidson.sample.jee.domain.service.FormateurService;

@ManagedBean
@RequestScoped
public class FormateurManagedBean {

    @Inject
    private FormateurService formateurService;

    private Formateur formateur;

    @PostConstruct
    private void init() {
        formateur = new Formateur();
    }

    public void createNew() {
        formateurService.create(formateur);
        formateur = new Formateur();
    }

    public Formateur getFormateur() {
        return formateur;
    }

    public void setFormateur(Formateur formateur) {
        this.formateur = formateur;
    }

}
