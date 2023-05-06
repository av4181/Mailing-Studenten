package studenten.model;

public class MailTemplateRood extends MailTemplate {
    public MailTemplateRood(PeriodeResultaat periodeResultaat) {
        super(periodeResultaat);
    }

    @Override
    public String getTitel() {
        return "Resultaten";
    }

    @Override
    public String getContent() {
        Student student = this.periodeResultaat.getStudent();

        String content = "";
        content += String.format("<p>Dag %s,</p>", student.getVoornaam());
        content += String.format("<p>Uit de resultaten van je examens van %s blijkt dat je voor geen enkel vak slaagde. Ik raad je sterk aan om op gesprek te komen. Boek een afspraak via deze link: %s</p>", periodeResultaat.getPeriode(), instelling.getLinkAfspraak());
        content += "<p>Met vriendelijke groeten,</p>";
        content += String.format("<p>%s %s</p>", instelling.getDocentVoornaam(), instelling.getDocentAchternaam());

        return content;
    }
}
