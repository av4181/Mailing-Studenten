package studenten.model;

public class MailTemplateRood extends MailTemplate {
    public MailTemplateRood(String titel, String content) {
        super(titel, content);
    }

    @Override
    protected String getTitelDefault() {
        return "Resultaten";
    }

    @Override
    protected String getContentDefault() {
        String content = "";
        content += "<p>Dag ${student.voornaam},</p>";
        content += "<p>Uit de resultaten van je examens van ${periode_resultaat.periode} blijkt dat je voor geen enkel vak slaagde. Ik raad je sterk aan om op gesprek te komen. Boek een afspraak via deze link: ${instelling.link_afspraak}</p>";
        content += "<p>Met vriendelijke groeten,</p>";
        content += "<p>${instelling.docent_voornaam} ${instelling.docent_achternaam}</p>";

        return content;
    }
}
