package de.t5book.pages;

import java.util.Random;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.ApplicationStateManager;

import de.t5book.entities.Item;
import de.t5book.entities.ShoppingCart;

public class Shop{
   @SessionState(create=false)
   @Property
   private ShoppingCart cart;
   
   @Property
   private boolean cartExists;
   
   @Inject
   private ApplicationStateManager applicationStateManager;

   
   void onActionFromCreateCart(){
	   applicationStateManager.get(ShoppingCart.class);
   }
   
   void onActionFromAddItem(){
	   Item item = new Item();
	   item.setPrice(new Random().nextDouble());
	   
	   cart.getItems().add(item);
   }

}
