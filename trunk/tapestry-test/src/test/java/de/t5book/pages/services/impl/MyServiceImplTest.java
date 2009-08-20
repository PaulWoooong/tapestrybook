package de.t5book.pages.services.impl;

import org.apache.tapestry5.ioc.test.TestBase;
import org.testng.annotations.Test;

import de.t5book.services.AnotherService;
import de.t5book.services.impl.MyServiceImpl;

public class MyServiceImplTest extends TestBase {

   @Test
   public void test_doBusiness() {
      AnotherService anotherService = newMock(AnotherService.class);
      MyServiceImpl myService = new MyServiceImpl(anotherService);

      expect(anotherService.doAnotherBusiness()).andReturn("test");
      
      replay();
      String result = myService.doBusiness();
      verify();

      assertEquals(result, "test");
   }
}
