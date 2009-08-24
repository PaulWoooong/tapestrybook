package de.t5book.pages;
public class Lifecycle{

   void pageLoaded(){
      System.out.println("pageLoaded()");
   }

   void pageAttached() {
      System.out.println("pageAttached()");
   }

   void pageDetached() {
      System.out.println("pageDetached()");
   }

   void onAction() {
      System.out.println("onAction()");
   }
}
