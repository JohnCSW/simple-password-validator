package xyz.johncsw.passwordValidator.rule;

public interface ValidationRule {
    public boolean validate(final String password);
    public String getFailedMessage();
}
