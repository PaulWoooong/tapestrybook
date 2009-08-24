package de.t5book.services.impl;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

import org.apache.tapestry5.Binding;
import org.apache.tapestry5.ioc.internal.util.TapestryException;

public class ListBinding implements Binding {
   private final List<Binding> bindings;

   public ListBinding(List<Binding> bindings) {
      this.bindings = bindings;
   }

   public Object get() {
      List<Object> values = new ArrayList<Object>(bindings.size());
      for (Binding next : bindings) {
         values.add(next.get());
      }
      return values;
   }

   public Class<List> getBindingType() {
      return List.class;
   }

   public boolean isInvariant() {
      return true;
   }

   public void set(Object value) {
      throw new TapestryException(
                    String.format("Binding %s is read-only", this),  
                    null, null);
   }

   public <T extends Annotation> T getAnnotation(
                             Class<T> annotationClass) {
      return null;
   }
}
