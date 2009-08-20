package de.t5book.pages;

import org.apache.tapestry5.ioc.annotations.Inject;

import de.t5book.services.MailingService;

public class Contact {
   @Inject
   private MailingService mailingService;
  
   void onSuccess() {
      mailingService.send("foo");
   }
}
