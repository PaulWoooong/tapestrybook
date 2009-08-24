package de.t5book.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.tapestry5.Binding;
import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.ioc.Location;
import org.apache.tapestry5.services.BindingFactory;
import org.apache.tapestry5.services.BindingSource;

public class ListBindingFactory implements BindingFactory {
   private final BindingSource bindingSource;

   public ListBindingFactory(BindingSource source) {
      this.bindingSource = source;
   }

   public Binding newBinding(String description,
                             ComponentResources container,
                             ComponentResources component,
                             String expression,
                             Location location) {
      List<Binding> bindings = new ArrayList<Binding>();
      String[] items = expression.split(",");
      for (String item : items) {
         Binding next = bindingSource.newBinding(
                                      description, 
                                      container,
                                      component,
                                      BindingConstants.PROP,
                                      item, 
                                      location);
         bindings.add(next);
      }
      return new ListBinding(bindings);
   }
}
