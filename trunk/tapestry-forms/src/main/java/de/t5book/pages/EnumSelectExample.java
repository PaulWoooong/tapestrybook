package de.t5book.pages;

import org.apache.tapestry5.SelectModel;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.util.EnumSelectModel;

import de.t5book.entities.PaymentType;

public class EnumSelectExample {

	@Persist
	@Property
	private PaymentType paymentType;

	@Inject
	private Messages messages;

	public SelectModel getOptions() {
		return new EnumSelectModel(PaymentType.class, messages);
	}

	void onSuccess() {
		System.out.println("paymentType = " + paymentType);
	}
}
