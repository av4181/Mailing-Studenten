package be.kdg.mailingstudenten.model;

public class MailTemplateGroen extends MailTemplate {
    public MailTemplateGroen(String titel, String content) {
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
        content += "<p>Proficiat, je bent voor alle vakken geslaagd in de examens van ${periode_resultaat.periode}.</p>";
        content += "<p>Doe zo verder.</p>";
        content += "<p>Met vriendelijke groeten,</p>";
        content += "<p>${instelling.docent_voornaam} ${instelling.docent_achternaam}</p>";

        return content;
    }
}
