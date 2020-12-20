package xyz.johncsw.passwordValidator.validator;

import xyz.johncsw.passwordValidator.rule.ValidationRule;

import java.util.ArrayList;
import java.util.List;

public class Validator {
    protected List<String> errorMessages;
    protected List<ValidationRule> validationRuleList;

    public Validator(final List<ValidationRule> validationRuleList) {
        this.validationRuleList = validationRuleList;
        errorMessages = new ArrayList<>();
    }
    public boolean check(final String password) {
        errorMessages.clear();
        for (final ValidationRule rule : validationRuleList) {
            if (rule.validate(password)) {
                continue;
            }
            errorMessages.add(rule.getFailedMessage());
        }
        return errorMessages.size() == 0;
    }
    public List<String> getErrorMessages() {
        return errorMessages;
    }
}
