package org.abhishek.hamcrest_matchers.complexObj;

public class BillAmount {

    private Integer amount;
    private BillType type;

    public Integer getAmount() {
        return amount;
    }

    public BillType getType() {
        return type;
    }

    public BillAmount() {
        amount = 0;
        type = BillType.GRID_TRANSMISSION;
        //type = BillType.DAY_USE_ONLY;
    }

    public BillAmount(Integer amount, BillType type) {
        this.amount = amount;
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format("amount: %d bill type: %s", amount, type);
    }

}