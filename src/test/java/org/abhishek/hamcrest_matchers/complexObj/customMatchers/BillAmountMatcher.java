package org.abhishek.hamcrest_matchers.complexObj.customMatchers;

import org.abhishek.hamcrest_matchers.complexObj.BillAmount;
import org.abhishek.hamcrest_matchers.complexObj.BillType;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class BillAmountMatcher extends TypeSafeMatcher<BillAmount> {

    private final Matcher<Integer> amount;
    private final Matcher<BillType> type;

    public BillAmountMatcher(Matcher<Integer> amount, Matcher<BillType> type) {
        this.amount = amount;
        this.type = type;
    }

    @Override
    protected boolean matchesSafely(BillAmount billAmount) {
        return amount.matches(billAmount.getAmount()) && type.matches(billAmount.getType());
    }

    @Override
    public void describeTo(Description description) {
        description.appendDescriptionOf(amount).appendDescriptionOf(type);
    }

    public static Matcher<BillAmount> billAmount(Matcher<Integer> amount, Matcher<BillType> type) {
        return new BillAmountMatcher(amount, type);
    }
}
