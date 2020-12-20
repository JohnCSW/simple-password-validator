package xyz.johncsw.passwordValidator.rule;

import xyz.johncsw.passwordValidator.constant.rule.RuleConfig;
import xyz.johncsw.passwordValidator.constant.rule.RuleFailingMessage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SubStringPatternRule implements ValidationRule{

    @Override
    public boolean validate(String password) {
        if (password == null) {
            return false;
        }
        final Pattern duplicatedPattern = Pattern.compile(
                RuleConfig.DUPLICATE_SUBSTRING_FINDING_REGEX
        );
        Matcher matcher = duplicatedPattern.matcher(password);
        String duplicatedSubstring = "";
        while(matcher.find()) {
            duplicatedSubstring = matcher.group(1);
        }
        return duplicatedSubstring.length() == 0;
    }

    @Override
    public String getFailedMessage() {
        return RuleFailingMessage.SUBSTRING_PATTERN_RULE;
    }
}
