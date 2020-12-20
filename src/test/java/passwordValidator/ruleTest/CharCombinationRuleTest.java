package passwordValidator.ruleTest;


import org.junit.Before;
import org.junit.Test;
import xyz.johncsw.passwordValidator.rule.CharCombinationRule;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CharCombinationRuleTest {
    private CharCombinationRule charCombinationRule;
    @Before
    public void setUp() {
        charCombinationRule = new CharCombinationRule();
    }
    @Test
    public void givenNullPasswordShouldFail() {
        boolean isFollowingRule = charCombinationRule.validate(null);
        assertFalse(isFollowingRule);
    }
    @Test
    public void givenPasswordTooShortShouldFail() {
        boolean isFollowingRule = charCombinationRule.validate("3");
        assertFalse(isFollowingRule);
    }
    @Test
    public void givenFewerAlphabetSouldFail() {
        boolean isFollowingRule = charCombinationRule.validate("3#1%");
        assertFalse(isFollowingRule);
    }
    @Test
    public void givenFewerDigitsSouldFail() {
        boolean isFollowingRule = charCombinationRule.validate("ab_$");
        assertFalse(isFollowingRule);
    }
    @Test
    public void givenHappyCaseShouldPass() {
        boolean isFollowingRule = charCombinationRule.validate("a123");
        assertTrue(isFollowingRule);
    }
}
