package be.kdg.mailingstudenten.model;

public abstract class MailTemplate {
    protected String titel;
    protected String content;

    public MailTemplate(String titel, String content) {
        if (titel.isEmpty()) {
            this.titel = this.getTitelDefault();
        } else {
            this.titel = titel;
        }

        if (content.isEmpty()) {
            this.content = this.getContentDefault();
        } else {
            this.content = content;
        }
    }

    public static MailTemplate voorPeriodeResultaat(PeriodeResultaat periodeResultaat) {
        Instelling instelling = new Instelling();

        PeriodeResultaat.KleurCode kleurCode = periodeResultaat.bepaalKleurCode();
        if (kleurCode == PeriodeResultaat.KleurCode.GROEN) {
            return instelling.getMailTemplateGroen();
        } else if (kleurCode == PeriodeResultaat.KleurCode.GEEL) {
            return instelling.getMailTemplateGeel();
        } else if (kleurCode == PeriodeResultaat.KleurCode.ORANJE) {
            return instelling.getMailTemplateOranje();
        } else {
            return instelling.getMailTemplateRood();
        }
    }

    public String getTitel() {
        return this.titel;
    }

    public String getContent() {
        return this.content;
    }

    protected abstract String getTitelDefault();
    protected abstract String getContentDefault();
}
