package fr.davidson.sample.jee.web;

import fr.davidson.sample.jee.domain.model.formation.Formateur;
import fr.davidson.sample.jee.domain.model.formation.SessionFormation;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.primefaces.event.RowEditEvent;
import fr.davidson.sample.jee.domain.service.FormateurService;
import fr.davidson.sample.jee.domain.service.SessionFormationService;

@ManagedBean
@RequestScoped
public class ListeSessionsFormationManagedBean1 {

    @Inject
    private SessionFormationService sessionFormationService;

    List<SessionFormation> sessionsFormation;

    @PostConstruct
    private void init() {
        sessionsFormation = sessionFormationService.findAll();
    }

    public List<SessionFormation> getSessionsFormation() {
        return sessionsFormation;
    }

    public void setSessionsFormation(List<SessionFormation> sessionsFormation) {
        this.sessionsFormation = sessionsFormation;
    }


   

}
