package studenten.model;

public abstract class MailTemplate {
    protected PeriodeResultaat periodeResultaat;
    protected Instelling instelling;

    public MailTemplate(PeriodeResultaat periodeResultaat, Instelling instelling) {
        this.periodeResultaat = periodeResultaat;
        this.instelling = instelling;
    }

    public static MailTemplate voorPeriodeResultaat(PeriodeResultaat periodeResultaat, Instelling instelling) {
        PeriodeResultaat.KleurCode kleurCode = periodeResultaat.bepaalKleurCode();
        if (kleurCode == PeriodeResultaat.KleurCode.GROEN) {
            return new MailTemplateGroen(periodeResultaat, instelling);
        } else if (kleurCode == PeriodeResultaat.KleurCode.GEEL) {
            return new MailTemplateGeel(periodeResultaat, instelling);
        } else if (kleurCode == PeriodeResultaat.KleurCode.ORANJE) {
            return new MailTemplateOranje(periodeResultaat, instelling);
        } else {
            return new MailTemplateRood(periodeResultaat, instelling);
        }
    }

    public abstract String getTitel();

    public abstract String getContent();
}
