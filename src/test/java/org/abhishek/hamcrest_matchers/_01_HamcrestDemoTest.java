package org.abhishek.hamcrest_matchers;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class _01_HamcrestDemoTest {
    // This is a test class for demonstrating the use of Hamcrest matchers in Java.
    // It includes various test cases to validate the functionality of Hamcrest matchers.
    // The tests are organized into different methods, each focusing on a specific aspect of Hamcrest matchers.

    // Test methods go here
    // For example:
    // @Test
    // public void testSomething() {
    //     assertThat(actualValue, is(expectedValue));
    // }

    @Test
    void testString() {
        String str = "Hello, World!";
        // Basic matchers
        assertThat(str, is("Hello, World!"));
        assertThat("Something is wrong", str, is("Hello, World!"));
        assertThat(str, containsString("World"));
        assertThat(str, startsWith("Hello"));
        assertThat(str, endsWith("!"));

        // nested matchers
        assertThat(str, allOf(startsWith("Hello"), endsWith("!")));
        assertThat(str, not(isEmptyString()));
    }

    @Test
    void testInteger() {
        int number = 42;
        // Basic matchers
        assertThat(number, is(42));
        assertThat(number, greaterThan(40));
        assertThat(number, lessThan(50));
        assertThat(number, allOf(greaterThan(40), lessThan(50)));
    }

    @Test
    void testCustomMatcher() {
        // Using the custom matcher
        assertThat(4, CustomIntegerMatcher.isEven());
        assertThat(5, not(CustomIntegerMatcher.isEven()));
    }
}
