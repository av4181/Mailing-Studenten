package studenten.model;

import java.util.List;

public class MailTemplateGeel extends MailTemplate {
    public MailTemplateGeel(PeriodeResultaat periodeResultaat) {
        super(periodeResultaat);
    }

    @Override
    public String getTitel() {
        return "Proficiat met je resultaat";
    }

    @Override
    public String getContent() {
        Student student = this.periodeResultaat.getStudent();

        List<Resultaat> nietGeslaagdeResultaten = periodeResultaat.getNietGeslaagdeResultaten();

        Resultaat nietGeslaagdResultaat = nietGeslaagdeResultaten.get(0);

        String content = "";
        content += String.format("<p>Dag %s,</p>", student.getVoornaam());
        content += String.format("<p>Je bent voor de meeste vakken geslaagd in de examens van %s. Jammer dat je niet slaagde voor %s (%.2f/20). Ga zeker naar het inzagerecht van dit vak.</p>", periodeResultaat.getPeriode(), nietGeslaagdResultaat.getRapportonderdeel(), nietGeslaagdResultaat.getPunt());
        content += "<p>Doe zo verder.</p>";
        content += "<p>Met vriendelijke groeten,</p>";
        content += String.format("<p>%s %s</p>", instelling.getDocentVoornaam(), instelling.getDocentAchternaam());

        return content;
    }
}
