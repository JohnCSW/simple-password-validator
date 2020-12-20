package xyz.johncsw.passwordValidator.beanConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import xyz.johncsw.passwordValidator.rule.CharCombinationRule;
import xyz.johncsw.passwordValidator.rule.LengthRule;
import xyz.johncsw.passwordValidator.rule.SubStringPatternRule;

@Configuration
public class ValidationRuleBeanConfig {
    @Bean
    public CharCombinationRule charCombinationRule() {
        return new CharCombinationRule();
    }
    @Bean
    public LengthRule lengthRule() {
        return new LengthRule();
    }
    @Bean
    public SubStringPatternRule subStringPatternRule() {
        return new SubStringPatternRule();
    }
}
