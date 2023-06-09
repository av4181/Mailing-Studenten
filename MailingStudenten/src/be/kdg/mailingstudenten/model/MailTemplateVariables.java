package be.kdg.mailingstudenten.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MailTemplateVariables {
    private InstellingenAlgemeen instellingen;
    private PeriodeResultaat periodeResultaat;
    private Map<String, String> variables;

    public MailTemplateVariables(PeriodeResultaat periodeResultaat) {
        this.instellingen = new InstellingenAlgemeen();
        this.periodeResultaat = periodeResultaat;
        this.variables = new HashMap<>();

        this.setUp();
    }

    private void setUp() {
        this.variables.put("student.voornaam", this.periodeResultaat.getStudent().getVoornaam());
        this.variables.put("student.achternaam", this.periodeResultaat.getStudent().getNaam());
        this.variables.put("student.email",this. periodeResultaat.getStudent().getEmail());
        this.variables.put("periode_resultaat.periode", this.periodeResultaat.getPeriode());

        Iterator<Resultaat> iterator = this.periodeResultaat.getNietGeslaagdeResultaten().iterator();
        String nietGeslaagdResultaten = "";
        while (iterator.hasNext()) {
            Resultaat resultaat = iterator.next();
            nietGeslaagdResultaten += String.format("%s (%.2f/20)", resultaat.getRapportonderdeel(), resultaat.getPunt());
            if (iterator.hasNext()) {
                nietGeslaagdResultaten += " en ";
            }
        }

        this.variables.put("periode_resultaat.niet_geslaagde_vakken", nietGeslaagdResultaten);
        this.variables.put("instelling.docent_voornaam", this.instellingen.getDocentVoornaam());
        this.variables.put("instelling.docent_achternaam", this.instellingen.getDocentAchternaam());
        this.variables.put("instelling.link_afspraak", this.instellingen.getLinkAfspraak());
    }

    public Map<String, String> getVariables() {
        return this.variables;
    }

    public static MailTemplateVariables voorPeriodeResultaat(PeriodeResultaat periodeResultaat) {
        return new MailTemplateVariables(periodeResultaat);
    }
}
