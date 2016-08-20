package fr.davidson.sample.jee.web;

import fr.davidson.sample.jee.domain.model.formation.Formation;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import fr.davidson.sample.jee.domain.service.FormationService;
import java.io.Serializable;
import javax.faces.view.ViewScoped;

@ManagedBean
@ViewScoped
public class FormationManagedBean implements Serializable{

    @Inject
    private FormationService formationService;

    private Formation formation;

    @PostConstruct
    private void init() {
        formation = new Formation();
    }

    public void createNew() {
        formationService.create(formation);
       init();
    }

    public Formation getFormation() {
        return formation;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }

 

}
