package org.abhishek.hamcrest_matchers.complexObj;

import org.abhishek.hamcrest_matchers.complexObj.customMatchers.BillAmountMatcher;
import org.abhishek.hamcrest_matchers.complexObj.customMatchers.EnergyBillMatcher;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class EnergyBillTest {

    @Test
    void matchEnergyBill() {

        // Create an instance of EnergyBill
        EnergyBill energyBill = new EnergyBill();
        energyBill.setId(1);
        energyBill.setAmount(new BillAmount(100, BillType.GRID_TRANSMISSION));

        // Assert that the energy bill matches the expected values
        assertThat(energyBill, EnergyBillMatcher.matchEnergyBill(
                equalTo(1),
                BillAmountMatcher.billAmount(equalTo(100), equalTo(BillType.GRID_TRANSMISSION))));
    }
}
