package fr.davidson.sample.jee.web;

import fr.davidson.sample.jee.domain.model.formation.Formateur;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.primefaces.event.RowEditEvent;
import fr.davidson.sample.jee.domain.service.FormateurService;

@ManagedBean
@RequestScoped
public class ListeFormateursManagedBean {

    @Inject
    private FormateurService formateurService;

    List<Formateur> formateurs;

    @PostConstruct
    private void init() {
        formateurs = formateurService.findAllFormateursNativeSql();
    }

    public List<Formateur> getFormateurs() {
        return formateurs;
    }

    public void setFormateurs(List<Formateur> formateurs) {
        this.formateurs = formateurs;
    }

    public void onRowEdit(RowEditEvent event) {
        final Formateur formateurEdite = (Formateur) event.getObject();
        FacesMessage msg = new FacesMessage("Formateur modifié",
                String.valueOf((formateurEdite).getId()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
        formateurService.edit(formateurEdite);
    }

    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Modification annulée",
                String.valueOf(((Formateur) event.getObject()).getId()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onDeleteFormateur(Formateur formateur) {
        formateurService.remove(formateur);
        init();
    }

}
