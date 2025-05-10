package org.abhishek.hamcrest_matchers;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class CustomIntegerMatcherWithType extends TypeSafeMatcher<Integer> {

    private final Matcher<Integer> expectedValue;

    public CustomIntegerMatcherWithType(Matcher<Integer> expectedValue) {
        this.expectedValue = expectedValue;
    }

    @Override
    protected boolean matchesSafely(Integer integer) {
        boolean outcome = expectedValue.matches(integer);
        return outcome;
    }

    @Override
    public void describeTo(Description description) {
        description.appendDescriptionOf(expectedValue);
    }

    public static CustomIntegerMatcherWithType matchInteger(Matcher<Integer> expectedValue) {
        return new CustomIntegerMatcherWithType(expectedValue);
    }
}
