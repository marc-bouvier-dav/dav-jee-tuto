package fr.davidson.sample.jee.web;

import fr.davidson.sample.jee.domain.model.formation.Formateur;
import fr.davidson.sample.jee.domain.model.formation.Formation;
import fr.davidson.sample.jee.domain.model.formation.SessionFormation;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import fr.davidson.sample.jee.domain.service.FormateurService;
import fr.davidson.sample.jee.domain.service.FormationService;
import fr.davidson.sample.jee.domain.service.SessionFormationService;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedProperty;
import javax.faces.view.ViewScoped;

@ManagedBean
@ViewScoped
public class SessionFormationManagedBean implements Serializable{

    @Inject
    private SessionFormationService sessionFormationService;
     @Inject
    private FormationService formationService;

    @Inject
    private FormateurService formateurService;

    private SessionFormation sessionFormation;

    private List<Formateur> formateurs;
    private List<Formation> formations;
    
    @PostConstruct
    private void init() {
        sessionFormation = new SessionFormation();
        formateurs = formateurService.findAll();
        formations = formationService.findAll();
    }

    public void createNew() {
        
        sessionFormationService.create(sessionFormation);
        init();
    }

    public SessionFormation getSessionFormation() {
        return sessionFormation;
    }

    public void setSessionFormation(SessionFormation sessionFormation) {
        this.sessionFormation = sessionFormation;
    }

    public List<Formateur> getFormateurs() {
        return formateurs;
    }

    public List<Formation> getFormations() {
        return formations;
    }

    
    
    
}
