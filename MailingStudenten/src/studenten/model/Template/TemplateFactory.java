//package studenten.model.Template;
//
//import java.time.LocalDate;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//public class TemplateFactory {
//
//    public static TemplateEmail createEmailTemplate(LocalDate today,
//                                                    String birthdayPersonNames,
//                                                    Record record) {
//
//        List<TemplateMaker> templates = Arrays.asList(new TemplateMakerReminder(record, birthdayPersonNames),
//                new TemplateMakerBirthday(record));
//
//        for (TemplateMaker template : templates) {
//            if (template.apply(today)) {
//                return template.createTemplate();
//            }
//        }
//
//        return createEmptyTemplate();
//    }
//
//    private static TemplateEmail createEmptyTemplate() {
//        String subject = "";
//        String template = "";
//        Map<String, String> valuesMap = new HashMap<>();
//        return new TemplateEmail(subject, template, valuesMap);
//    }
//}
