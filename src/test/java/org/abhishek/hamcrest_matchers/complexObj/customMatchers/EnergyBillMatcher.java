package org.abhishek.hamcrest_matchers.complexObj.customMatchers;

import org.abhishek.hamcrest_matchers.complexObj.BillAmount;
import org.abhishek.hamcrest_matchers.complexObj.EnergyBill;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class EnergyBillMatcher extends TypeSafeMatcher<EnergyBill> {

    private final Matcher<BillAmount> billAmountMatcher;
    private final Matcher<Integer> idMatcher;

    public EnergyBillMatcher(Matcher<BillAmount> billAmountMatcher, Matcher<Integer> idMatcher) {
        this.billAmountMatcher = billAmountMatcher;
        this.idMatcher = idMatcher;
    }

    @Override
    protected boolean matchesSafely(EnergyBill energyBill) {
        return billAmountMatcher.matches(energyBill.getAmount()) && idMatcher.matches(energyBill.getId());
    }

    @Override
    public void describeTo(Description description) {
        description.appendDescriptionOf(this.billAmountMatcher).appendDescriptionOf(this.idMatcher);
    }

    public static Matcher<EnergyBill> matchEnergyBill(Matcher<Integer> idMatcher, Matcher<BillAmount> billAmountMatcher) {
        return new EnergyBillMatcher(billAmountMatcher, idMatcher);
    }
}
