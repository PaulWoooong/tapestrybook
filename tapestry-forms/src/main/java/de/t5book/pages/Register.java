package de.t5book.pages;

import java.io.File;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.tapestry5.SelectModel;
import org.apache.tapestry5.ValidationException;
import org.apache.tapestry5.ValueEncoder;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.beaneditor.Width;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.upload.services.UploadedFile;
import org.apache.tapestry5.util.EnumSelectModel;
import org.apache.tapestry5.util.EnumValueEncoder;

import de.t5book.entities.Language;

public class Register {
	@Persist
	@Property
	private String userName;

	@Persist
	@Property
	@Width(30)
	private String password;

	@Persist
	@Property
	@Width(30)
	private String password2;

	@Persist
	@Property
	private String email;

	@Persist
	@Property
	private Date birthday;

	@Persist
	@Property
	private String gender;

	@Persist
	@Property
	private String signature;

	@Persist
	@Property
	private boolean subscribeNewsletter;

	@Persist
	@Property
	private String paymentType;

	@Persist
	@Property
	private List<Language> selectedLanguages;

	@Property
	private UploadedFile uploadedFile;

	@Inject
	private Messages messages;

	@InjectComponent
	private Form registerForm;

	void onValidateFromBirthday(Date value) throws ValidationException {
		System.err.println("onValidateFromBirthday: " + value);
		System.err.println("birthday: " + birthday);

		if (value != null && value.after(new Date())) {
			throw new ValidationException(
					"Ihr Geburtstag liegt in der Zukunft.");
		}
	}

	void onValidateForm() {
		if (!registerForm.getHasErrors()) {
			if (!password.equals(password2)) {
				registerForm.recordError("Passwort .");
			}

			if ("root".equals(userName)) {
				registerForm.recordError("Der Name ist bereits vergeben.");
			}
		}
	}

	public SelectModel getLanguagesModel() {
		return new EnumSelectModel(Language.class, messages);
	}

	public ValueEncoder getLanguageEncoder() {
		return new EnumValueEncoder(Language.class);
	}

	public List<String> getOptions() {
		return Arrays.asList("Credit Card", "Bank Transfer", "Cash", "PayPal");

	}

	void onSuccess() {
		System.out.println("userName = " + userName);
		System.out.println("password = " + password);
		System.out.println("password2 = " + password2);
		System.out.println("birthday = " + birthday);
		System.out.println("email = " + email);
		System.out.println("gender = " + gender);
		System.out.println("paymentType = " + paymentType);
		System.out.println("signature = " + signature);
		System.out.println("subscribeNewsletter = " + subscribeNewsletter);

		for (Language language : selectedLanguages) {
			System.out.println("Programmiersprache: " + language.name());
		}
		if (uploadedFile != null) {
			
			String tempDir = System.getProperty("java.io.tmpdir");

			File file = new File(tempDir + uploadedFile.getFileName());
			
			System.out.println("Avatar = " + file.getAbsolutePath());

			uploadedFile.write(file);
		}
	}

}
