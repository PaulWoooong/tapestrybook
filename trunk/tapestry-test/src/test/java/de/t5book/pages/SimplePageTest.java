package de.t5book.pages;

import static org.testng.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.apache.tapestry5.dom.Document;
import org.apache.tapestry5.dom.Element;
import org.apache.tapestry5.ioc.MappedConfiguration;
import org.apache.tapestry5.test.PageTester;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import de.t5book.pages.Index;
import de.t5book.pages.services.impl.TestableMailingService;
import de.t5book.services.MailingService;

public class SimplePageTest {
	private PageTester tester;

	@Test
	public void simple_test() {
		Document document = tester.renderPage(Index.class.getSimpleName());

		assertTrue(document.toString().contains("Tapestry 5 Test"));

	}

	@Test
	public void test_link() {
		Document document = tester.renderPage(Index.class.getSimpleName());
		Element link = document.getElementById("loginLink");

		Document loginDocument = tester.clickLink(link);
		assertTrue(loginDocument.toString().contains("Login"));
	}

	@Test
	public void test_form() {
		Document document = tester.renderPage(Login.class.getSimpleName());
		Element form = document.getElementById("form");

		Map<String, String> fieldValues = new HashMap<String, String>();

		fieldValues.put("userName", "Igor");
		document = tester.submitForm(form, fieldValues);
		assertTrue(document.toString().contains(
				"You must provide a value for Password."));

		fieldValues.put("password", "falsches-passwort");
		document = tester.submitForm(form, fieldValues);
		assertTrue(document.toString().contains("Passwort ist falsch."));

		fieldValues.put("password", "secret");
		document = tester.submitForm(form, fieldValues);
		assertTrue(document.toString().contains("Herzlich Willkommen, Igor!"));
	}

	@Test
	public void test_contact() {
		Document document = tester.renderPage(Contact.class.getSimpleName());

		Element form = document.getElementById("form");
		tester.submitForm(form, new HashMap<String, String>());

	}

	@Test
	public void test_loop() {
		Document document = tester.renderPage(LoopTestPage.class
				.getSimpleName());
		String content = document.toString();

		assertTrue(content.contains("1"));
		assertTrue(content.contains("2"));
		assertTrue(content.contains("3"));
		assertTrue(content.contains("4"));
		assertTrue(content.contains("5"));
	}

	public static class LocalModule {
		public static void contributeServiceOverride(
				MappedConfiguration<Class, Object> configuration) {
			configuration.add(MailingService.class,
					new TestableMailingService());
		}
	}

	@BeforeClass
	public void setup() {
		tester = new PageTester("de.t5book", "app", "src/main/webapp",
				LocalModule.class);
	}
}