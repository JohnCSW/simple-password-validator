package xyz.johncsw.passwordValidator.rule;

import xyz.johncsw.passwordValidator.constant.rule.RuleConfig;
import xyz.johncsw.passwordValidator.constant.rule.RuleFailingMessage;

public class CharCombinationRule implements ValidationRule{
    @Override
    public boolean validate(final String password) {
        int requiredChars = RuleConfig.MIN_ALPHABET + RuleConfig.MIN_DIGITS;
        if (password == null || password.length() < requiredChars) {
            return false;
        }

        int[] charCounter = new int[2];
        for (int i = 0; i < password.length(); ++i) {
            char passChar = password.charAt(i);
            if (Character.isAlphabetic(passChar)) {
                ++charCounter[0];
            } else if (Character.isDigit(passChar)){
                ++charCounter[1];
            }
        }

        boolean isFollowingRule =
                charCounter[0] >= RuleConfig.MIN_ALPHABET
                && charCounter[1] >= RuleConfig.MIN_DIGITS;

        return isFollowingRule;
    }

    @Override
    public String getFailedMessage() {
        return RuleFailingMessage.CHAR_COMBINATION_RULE;
    }
}
