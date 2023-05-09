package studenten.model;

public class MailTemplateGeel extends MailTemplate {
    public MailTemplateGeel(String titel, String content) {
        super(titel, content);
    }

    @Override
    protected String getTitelDefault() {
        return "Proficiat met je resultaat";
    }

    @Override
    protected String getContentDefault() {
        String content = "";
        content += "<p>Dag ${student.voornaam},</p>";
        content += "<p>Je bent voor de meeste vakken geslaagd in de examens van ${periode_resultaat.periode}. Jammer dat je niet slaagde voor ${periode_resultaat.niet_geslaagde_vakken}. Ga zeker naar het inzagerecht van dit vak.</p>";
        content += "<p>Doe zo verder.</p>";
        content += "<p>Met vriendelijke groeten,</p>";
        content += "<p>${instelling.docent_voornaam} ${instelling.docent_achternaam}</p>";

        return content;
    }
}
