package studenten.model;

public class MailTemplateGroen extends MailTemplate {
    public MailTemplateGroen(PeriodeResultaat periodeResultaat) {
        super(periodeResultaat);
    }

    @Override
    public String getTitel() {
        return "Proficiat met je resultaat";
    }

    @Override
    public String getContent() {
        Student student = this.periodeResultaat.getStudent();

        String content = "";
        content += String.format("<p>Dag %s,</p>", student.getVoornaam());
        content += String.format("<p>Proficiat, je bent voor alle vakken geslaagd in de examens van %s.</p>", periodeResultaat.getPeriode());
        content += "<p>Doe zo verder.</p>";
        content += "<p>Met vriendelijke groeten,</p>";
        content += String.format("<p>%s %s</p>", instelling.getDocentVoornaam(), instelling.getDocentAchternaam());

        return content;
    }
}
