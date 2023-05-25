package be.kdg.mailingstudenten.model;

import org.apache.commons.text.StringSubstitutor;

public class MailTemplatePopulator {
    private StringSubstitutor stringSubstitutor;

    public MailTemplatePopulator() {
        this.stringSubstitutor = new StringSubstitutor();
    }

    public VerstuurbareMailTemplate populate(MailTemplate mailTemplate, MailTemplateVariables mailTemplateVariables) {
        StringSubstitutor stringSubstitutor = new StringSubstitutor(mailTemplateVariables.getVariables());
        String content = stringSubstitutor.replace(mailTemplate.getContent());

        return new VerstuurbareMailTemplate(mailTemplate.getTitel(), content);
    }
}
