package studenten.model;

public abstract class MailTemplate {
    protected PeriodeResultaat periodeResultaat;
    protected Instelling instelling;

    public MailTemplate(PeriodeResultaat periodeResultaat) {
        this.periodeResultaat = periodeResultaat;
        this.instelling = new Instelling();
    }

    public static MailTemplate voorPeriodeResultaat(PeriodeResultaat periodeResultaat) {
        PeriodeResultaat.KleurCode kleurCode = periodeResultaat.bepaalKleurCode();
        if (kleurCode == PeriodeResultaat.KleurCode.GROEN) {
            return new MailTemplateGroen(periodeResultaat);
        } else if (kleurCode == PeriodeResultaat.KleurCode.GEEL) {
            return new MailTemplateGeel(periodeResultaat);
        } else if (kleurCode == PeriodeResultaat.KleurCode.ORANJE) {
            return new MailTemplateOranje(periodeResultaat);
        } else {
            return new MailTemplateRood(periodeResultaat);
        }
    }

    public abstract String getTitel();

    public abstract String getContent();
}
