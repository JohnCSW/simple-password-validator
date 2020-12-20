package xyz.johncsw.passwordValidator.beanConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import xyz.johncsw.passwordValidator.rule.CharCombinationRule;
import xyz.johncsw.passwordValidator.rule.LengthRule;
import xyz.johncsw.passwordValidator.rule.SubStringPatternRule;
import xyz.johncsw.passwordValidator.validator.DefaultValidator;

import java.util.Arrays;

@Configuration
public class ValidatorBeanConfig {
    @Autowired
    private CharCombinationRule charCombinationRule;
    @Autowired
    private LengthRule lengthRule;
    @Autowired
    private SubStringPatternRule subStringPatternRule;

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public DefaultValidator defaultValidator() {
        return new DefaultValidator(
                Arrays.asList(
                        charCombinationRule,
                        lengthRule,
                        subStringPatternRule
                )
        );
    }
}
