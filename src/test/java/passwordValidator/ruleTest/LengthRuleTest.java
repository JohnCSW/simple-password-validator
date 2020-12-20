package passwordValidator.ruleTest;

import org.junit.Before;
import org.junit.Test;
import xyz.johncsw.passwordValidator.rule.LengthRule;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LengthRuleTest {

    private LengthRule lengthRule;
    @Before
    public void setUp() {
        lengthRule = new LengthRule();
    }
    @Test
    public void givenNullStringShouldFail() {
        boolean isFollwingRule = lengthRule.validate(null);
        assertFalse(isFollwingRule);
    }
    @Test
    public void givenPasswordTooShortShouldFail() {
        boolean isFollwingRule = lengthRule.validate("a222");
        assertFalse(isFollwingRule);
    }
    @Test
    public void givenPasswordTooLongShouldFail() {
        boolean isFollwingRule = lengthRule.validate("abcdef0123456789");
        assertFalse(isFollwingRule);
    }
    @Test
    public void givenHappyCaseShouldPass() {
        boolean isFollwingRule = lengthRule.validate("a_1234");
        assertTrue(isFollwingRule);
    }
}
