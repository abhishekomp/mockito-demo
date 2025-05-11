package org.abhishek.hamcrest_matchers.complexObj;

public class EnergyBill {

	private Integer id;
	private BillAmount amount;
	//private Customer customer;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BillAmount getAmount() {
		return amount;
	}

	public void setAmount(BillAmount amount) {
		this.amount = amount;
	}

/*	public Customer getCustomer() {
		return customer;
	}*/

/*	public void setCustomer(Customer customer) {
		this.customer = customer;
	}*/

	@Override
	public String toString() {
		return String.format("id: %d customer: %s billamount: %s", id, amount);
	}

/*
	@Override
	public String toString() {
		return String.format("id: %d customer: %s billamount: %s", id, customer, amount);
	}
*/

}