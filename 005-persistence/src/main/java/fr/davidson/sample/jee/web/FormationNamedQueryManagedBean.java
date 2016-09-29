package fr.davidson.sample.jee.web;

import fr.davidson.sample.jee.domain.model.formation.Formation;
import fr.davidson.sample.jee.domain.model.formation.Sujet;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import fr.davidson.sample.jee.domain.service.FormationService;
import fr.davidson.sample.jee.domain.service.SujetService;
import java.io.Serializable;
import java.util.HashSet;
import javax.faces.view.ViewScoped;
import java.util.List;
import javax.faces.event.ActionEvent;

@ManagedBean
@ViewScoped
public class FormationNamedQueryManagedBean implements Serializable {

    @Inject
    private FormationService formationService;

    @Inject
    private SujetService sujetService;

    private List<Formation> formations;

    private String codeSujet;
    private List<Sujet> sujets;

    @PostConstruct
    private void init() {
        sujets = sujetService.findAll();
        if (sujets == null || (sujets !=null && sujets.isEmpty())) {
            final Sujet  sujetJava= newSujet("java", "Java");
            sujetService.create(sujetJava);
            final Sujet sujetSST = newSujet("sst", "Secourisme au travail");
            sujetService.create(sujetSST);
            final Sujet sujetScala = newSujet("scala", "Scala");
            sujetService.create(sujetScala);
            
            sujets = sujetService.findAll();
            createFormations();
            
           
        }
    }

    
    public void createFormations(){
        
          formationService.create(newFormation("Formation Java",sujets.get(0)));
            formationService.create(newFormation("Formation Java EE", sujets.get(0)));
            formationService.create(newFormation("Formation Java EE avancée", sujets.get(0)));
            
            
            formationService.create(newFormation("Formation SST initiale", sujets.get(1)));
            formationService.create(newFormation("Recyclage SST", sujets.get(1)));
            
            formationService.create(newFormation("Formation Scala", sujets.get(2)));
            formationService.create(newFormation("Formation Scala pour data scientists", sujets.get(2)));
    }
    private Formation newFormation(final String libelle, final Sujet sujetFormation) {
        final Formation newFormation = new Formation();
        newFormation.setLibelle(libelle);
        final HashSet<Sujet> hashSet = new HashSet<Sujet>();
        hashSet.add(sujetFormation);
        newFormation.setSujets(hashSet);
        return newFormation;
    }

    private Sujet newSujet(final String id, final String libelle) {
        final Sujet nouveauSujet = new Sujet();
        nouveauSujet.setCode(id);
        nouveauSujet.setLibelle(libelle);
        return nouveauSujet;
    }

    public void searchFromSujet() {
        Sujet sujet = sujetService.find(codeSujet);
        formations = formationService.findWithSujet(sujet);
    }

    public List<Formation> getFormations() {
        return formations;
    }

    public void setFormations(List<Formation> formations) {
        this.formations = formations;
    }

    public List<Sujet> getSujets() {
        return sujets;
    }

    public void setSujets(List<Sujet> sujets) {
        this.sujets = sujets;
    }

    public String getCodeSujet() {
        return codeSujet;
    }

    public void setCodeSujet(String codeSujet) {
        this.codeSujet = codeSujet;
    }

    
}
