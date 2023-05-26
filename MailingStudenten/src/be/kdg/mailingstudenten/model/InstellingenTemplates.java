package be.kdg.mailingstudenten.model;

public class InstellingenTemplates extends Instellingen {
    private MailTemplate mailTemplateGroen;
    private MailTemplate mailTemplateGeel;
    private MailTemplate mailTemplateOranje;
    private MailTemplate mailTemplateRood;

    public InstellingenTemplates() {
        this.mailTemplateGroen = new MailTemplateGroen(preferences.get("mailTemplateGroenTitel", ""), preferences.get("mailTemplateGroenContent", ""));
        this.mailTemplateGeel = new MailTemplateGeel(preferences.get("mailTemplateGeelTitel", ""), preferences.get("mailTemplateGeelContent", ""));
        this.mailTemplateOranje = new MailTemplateOranje(preferences.get("mailTemplateOranjeTitel", ""), preferences.get("mailTemplateOranjeContent", ""));
        this.mailTemplateRood = new MailTemplateRood(preferences.get("mailTemplateRoodTitel", ""), preferences.get("mailTemplateRoodContent", ""));
    }

    @Override
    public void opslaan() {
        preferences.put("mailTemplateGroenTitel", mailTemplateGroen.titel);
        preferences.put("mailTemplateGroenContent", mailTemplateGroen.content);
        preferences.put("mailTemplateGeelTitel", mailTemplateGeel.titel);
        preferences.put("mailTemplateGeelContent", mailTemplateGeel.content);
        preferences.put("mailTemplateOranjeTitel", mailTemplateOranje.titel);
        preferences.put("mailTemplateOranjeContent", mailTemplateOranje.content);
        preferences.put("mailTemplateRoodTitel", mailTemplateRood.titel);
        preferences.put("mailTemplateRoodContent", mailTemplateRood.content);
    }

    public MailTemplate getMailTemplateGroen() {
        return mailTemplateGroen;
    }

    public void setMailTemplateGroen(MailTemplate mailTemplateGroen) {
        this.mailTemplateGroen = mailTemplateGroen;
    }

    public MailTemplate getMailTemplateGeel() {
        return mailTemplateGeel;
    }

    public void setMailTemplateGeel(MailTemplate mailTemplateGeel) {
        this.mailTemplateGeel = mailTemplateGeel;
    }

    public MailTemplate getMailTemplateOranje() {
        return mailTemplateOranje;
    }

    public void setMailTemplateOranje(MailTemplate mailTemplateOranje) {
        this.mailTemplateOranje = mailTemplateOranje;
    }

    public MailTemplate getMailTemplateRood() {
        return mailTemplateRood;
    }

    public void setMailTemplateRood(MailTemplate mailTemplateRood) {
        this.mailTemplateRood = mailTemplateRood;
    }
}
