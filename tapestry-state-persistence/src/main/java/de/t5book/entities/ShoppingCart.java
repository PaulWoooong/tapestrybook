package de.t5book.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShoppingCart {

	private Date created;
	private List<Item> items = new ArrayList<Item>();


	public ShoppingCart(Date created) {
		super();
		this.created = created;
	}
	
	public Date getCreated() {
		return created;
	}
	
	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	public Double getSum(){
		double sum = 0;
		for (Item next : items) {
			sum+=next.getPrice();
		}
		return sum;
	}
}
