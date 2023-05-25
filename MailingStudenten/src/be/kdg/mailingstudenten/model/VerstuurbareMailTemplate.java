package be.kdg.mailingstudenten.model;

public class VerstuurbareMailTemplate {
    protected String titel;
    protected String content;

    public VerstuurbareMailTemplate(String titel, String content) {
        this.titel = titel;
        this.content = content;
    }

    public String getTitel() {
        return this.titel;
    }

    public String getContent() {
        return this.content;
    }
}
