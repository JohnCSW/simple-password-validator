package xyz.johncsw.passwordValidator.validator;

import xyz.johncsw.passwordValidator.rule.ValidationRule;

import java.util.List;

public class DefaultValidator extends Validator{
    public DefaultValidator(final List<ValidationRule> validationRuleList) {
        super(validationRuleList);
    }
}
