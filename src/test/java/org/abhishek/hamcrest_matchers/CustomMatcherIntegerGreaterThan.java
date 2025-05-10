package org.abhishek.hamcrest_matchers;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public class CustomMatcherIntegerGreaterThan extends TypeSafeMatcher<Integer> {

    private final int expectedValue;

    public CustomMatcherIntegerGreaterThan(int expectedValue) {
        this.expectedValue = expectedValue;
    }

    @Override
    protected boolean matchesSafely(Integer integer) {
        return integer > expectedValue;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("an integer greater than ").appendValue(expectedValue);
    }

    public static CustomMatcherIntegerGreaterThan greaterThan(int expectedValue) {
        return new CustomMatcherIntegerGreaterThan(expectedValue);
    }
}
