package xyz.johncsw.passwordValidator.rule;

import xyz.johncsw.passwordValidator.constant.rule.RuleConfig;
import xyz.johncsw.passwordValidator.constant.rule.RuleFailingMessage;

public class LengthRule implements ValidationRule{
    @Override
    public boolean validate(String password) {
        if (password == null) {
            return false;
        }
        int passwordLength = password.length();
        boolean isFollowingRule = passwordLength <= RuleConfig.MAX_PASSWORD_LENGTH
                && passwordLength >= RuleConfig.MIN_PASSWORD_LENGTH;
        return isFollowingRule;
    }

    @Override
    public String getFailedMessage() {
        return RuleFailingMessage.LENGTH_RULE;
    }
}
