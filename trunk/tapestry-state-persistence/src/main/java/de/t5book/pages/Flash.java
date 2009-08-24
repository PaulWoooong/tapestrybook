package de.t5book.pages;

import org.apache.tapestry5.PersistenceConstants;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;

public class Flash{
   @Persist(PersistenceConstants.FLASH)
   @Property
   private String message;

   void onAction() {
      message = "Sie haben den Prozess gestartet.";
   }
}
