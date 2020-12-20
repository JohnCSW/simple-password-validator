package xyz.johncsw.passwordValidator.constant.rule;

public class RuleFailingMessage {
    public static String CHAR_COMBINATION_RULE;
    public static String LENGTH_RULE;
    public static String SUBSTRING_PATTERN_RULE;
    static {
        CHAR_COMBINATION_RULE = "Characters combination didn't match.";
        LENGTH_RULE = "Illegal length.";
        SUBSTRING_PATTERN_RULE = "Duplicated string right after a string is not allowed.";
    }
}
