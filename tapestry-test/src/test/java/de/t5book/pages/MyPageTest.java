package de.t5book.pages;

import org.apache.tapestry5.ioc.test.TestBase;
import org.apache.tapestry5.services.Request;
import org.apache.tapestry5.test.TapestryTestCase;
import org.testng.annotations.Test;

public class MyPageTest extends TapestryTestCase {
   @Test
   public void test_onAction() {
	   
      Request request = mockRequest();
      MyPage page = TestBase.create(MyPage.class,
                                    "request", request);

      expect(request.getServerName()).andReturn("localhost");

      replay();
      page.onAction();
      verify();

      String serverName = (String) TestBase.get(page, "serverName");
      assertEquals(serverName, "localhost");
   }
}
