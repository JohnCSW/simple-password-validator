package passwordValidator.validatorTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xyz.johncsw.passwordValidator.beanConfig.ValidationRuleBeanConfig;
import xyz.johncsw.passwordValidator.beanConfig.ValidatorBeanConfig;
import xyz.johncsw.passwordValidator.constant.rule.RuleFailingMessage;
import xyz.johncsw.passwordValidator.validator.DefaultValidator;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ValidatorBeanConfig.class, ValidationRuleBeanConfig.class})
public class DefaultValidatorTest {
    @Autowired
    private DefaultValidator defaultValidator;

    @Test
    public void violateOnlyLengthRuleShouldFail() {
        boolean isFollowingRules = defaultValidator.check("a123");
        boolean hasSameErrorMessages = Arrays
                .asList(RuleFailingMessage.LENGTH_RULE)
                .containsAll(defaultValidator.getErrorMessages());
        assertFalse(isFollowingRules);
        assertTrue(hasSameErrorMessages);
    }
    @Test
    public void violateOnlyCharCombinationRuleShouldFail() {
        boolean isFollowingRules = defaultValidator.check("12324");
        boolean hasSameErrorMessages = Arrays
                .asList(RuleFailingMessage.CHAR_COMBINATION_RULE)
                .containsAll(defaultValidator.getErrorMessages());
        assertFalse(isFollowingRules);
        assertTrue(hasSameErrorMessages);
    }
    @Test
    public void violateOnlySubStringPatternnRuleShouldFail() {
        boolean isFollowingRules = defaultValidator.check("a12323");
        boolean hasSameErrorMessages = Arrays
                .asList(RuleFailingMessage.SUBSTRING_PATTERN_RULE)
                .containsAll(defaultValidator.getErrorMessages());
        assertFalse(isFollowingRules);
        assertTrue(hasSameErrorMessages);
    }
    @Test
    public void violateAllRulesShouldFail() {
        boolean isFollowingRules = defaultValidator.check("1233");
        boolean hasSameErrorMessages = Arrays
                .asList(
                    RuleFailingMessage.LENGTH_RULE,
                    RuleFailingMessage.CHAR_COMBINATION_RULE,
                    RuleFailingMessage.SUBSTRING_PATTERN_RULE
                )
                .containsAll(defaultValidator.getErrorMessages());
        assertFalse(isFollowingRules);
        assertTrue(hasSameErrorMessages);
    }
    @Test
    public void violateNoRuleShouldPass() {
        boolean isFollowingRules = defaultValidator.check("a1234");
        assertTrue(isFollowingRules);
        assertTrue(
                defaultValidator
                        .getErrorMessages()
                        .isEmpty()
        );
    }

}
