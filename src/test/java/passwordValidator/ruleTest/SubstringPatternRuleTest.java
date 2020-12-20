package passwordValidator.ruleTest;

import org.junit.Before;
import org.junit.Test;
import xyz.johncsw.passwordValidator.rule.SubStringPatternRule;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SubstringPatternRuleTest {
    private SubStringPatternRule subStringPatternRule;
    @Before
    public void setUp() {
        subStringPatternRule = new SubStringPatternRule();
    }

    @Test
    public void givenNullShouldFail() {
        boolean isFollowingRule = subStringPatternRule.validate(null);
        assertFalse(isFollowingRule);
    }

    @Test
    public void giveConsecutiveSubStringShouldFail() {
        boolean isFollowingRule = subStringPatternRule.validate("a1abacbac12");
        assertFalse(isFollowingRule);
    }

    @Test
    public void giveHappyCaseShouldPass() {
        boolean isFollowingRule = subStringPatternRule.validate("a1234123");
        assertTrue(isFollowingRule);
    }

}
