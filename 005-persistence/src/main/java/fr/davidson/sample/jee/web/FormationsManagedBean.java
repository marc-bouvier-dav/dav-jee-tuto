package fr.davidson.sample.jee.web;

import fr.davidson.sample.jee.domain.model.formation.Formation;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import fr.davidson.sample.jee.domain.service.FormationService;
import java.io.Serializable;
import java.util.List;
import javax.faces.view.ViewScoped;

@ManagedBean
@ViewScoped
public class FormationsManagedBean implements Serializable{

    @Inject
    private FormationService formationService;

    private Formation selectedFormation;
    private List<Formation> formations;

    @PostConstruct
    private void init() {
        formations = formationService.findAll();
    }

    public Formation getSelectedFormation() {
        return selectedFormation;
    }

    public void setSelectedFormation(Formation selectedFormation) {
        this.selectedFormation = selectedFormation;
    }

    public List<Formation> getFormations() {
        return formations;
    }

    public void setFormations(List<Formation> formations) {
        this.formations = formations;
    }

    
 

 

}
