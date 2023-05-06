package studenten.model;

import java.util.Iterator;

public class MailTemplateOranje extends MailTemplate {
    public MailTemplateOranje(PeriodeResultaat periodeResultaat) {
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
        content += String.format("<p>Je examens van %s verliepen niet zo goed maar ook niet dramatisch. Jammer dat je niet slaagde voor de vakken", periodeResultaat.getPeriode());

        Iterator<Resultaat> iterator = periodeResultaat.getNietGeslaagdeResultaten().iterator();
        while (iterator.hasNext()) {
            Resultaat resultaat = iterator.next();
            content += String.format("%s (%.2f/20)", resultaat.getRapportonderdeel(), resultaat.getPunt());
            if (iterator.hasNext()) {
                content += " en ";
            }
        }

        content += String.format(". Graag had ik hierover een gesprek met je. Boek een afspraak via deze link %s Ga alvast zeker naar het inzagerecht van deze vakken..</p>", instelling.getLinkAfspraak());
        content += "<p>Graag tot dan.</p>";
        content += "<p>Met vriendelijke groeten,</p>";
        content += String.format("<p>%s %s</p>", instelling.getDocentVoornaam(), instelling.getDocentAchternaam());

        return content;
    }
}
