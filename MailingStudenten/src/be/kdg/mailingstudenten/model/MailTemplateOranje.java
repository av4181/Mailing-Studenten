package be.kdg.mailingstudenten.model;

public class MailTemplateOranje extends MailTemplate {
    public MailTemplateOranje(String titel, String content) {
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
        content += "<p>Je examens van ${periode_resultaat.periode} verliepen niet zo goed maar ook niet dramatisch. Jammer dat je niet slaagde voor de vakken ${periode_resultaat.niet_geslaagde_vakken}";
        content += ". Graag had ik hierover een gesprek met je. Boek een afspraak via deze link ${instelling.link_afspraak} Ga alvast zeker naar het inzagerecht van deze vakken..</p>";
        content += "<p>Graag tot dan.</p>";
        content += "<p>Met vriendelijke groeten,</p>";
        content += "<p>${instelling.docent_voornaam} ${instelling.docent_achternaam}</p>";

        return content;
    }
}
