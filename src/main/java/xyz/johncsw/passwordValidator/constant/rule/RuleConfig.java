package xyz.johncsw.passwordValidator.constant.rule;

public class RuleConfig {
    public static int MIN_ALPHABET;
    public static int MIN_DIGITS;
    public static int MIN_PASSWORD_LENGTH;
    public static int MAX_PASSWORD_LENGTH;
    public static String DUPLICATE_SUBSTRING_FINDING_REGEX;

    static {
        MIN_ALPHABET = 1;
        MIN_DIGITS = 1;
        MIN_PASSWORD_LENGTH = 5;
        MAX_PASSWORD_LENGTH = 12;
        DUPLICATE_SUBSTRING_FINDING_REGEX = "(\\w+)\\1";
    }
}
