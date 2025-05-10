package org.abhishek.hamcrest_matchers;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;

public class _02_CustomIntegerMatcherTest {

    @Test
    void testCustomIntegerMatcher() {
        // Using the custom matcher
        assertThat(4, CustomIntegerMatcher.isEven());
        assertThat(5, not(CustomIntegerMatcher.isEven()));
    }

    @Test
    void testCustomMatcherIntegerGreaterThan() {
        // Using the custom matcher for integers greater than a specific value
        assertThat(5, CustomMatcherIntegerGreaterThan.greaterThan(4));
        assertThat(3, not(CustomMatcherIntegerGreaterThan.greaterThan(4)));
    }
}
