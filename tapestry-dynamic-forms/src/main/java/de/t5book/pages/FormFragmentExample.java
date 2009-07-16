package de.t5book.pages;

import org.apache.tapestry5.annotations.Property;

import de.t5book.entities.Address;

public class FormFragmentExample {

	@Property
	private Address billingAdress;
	
	@Property
	private Address shippingAdress;
	
    @Property
    private boolean shipToAnotherAddress;

	void onPrepare() {
		billingAdress = new Address();
		shippingAdress = new Address();
	}
	
	void onSuccess(){
		System.err.println(billingAdress.getStreet());
		System.err.println(shippingAdress.getStreet());
	}
}
