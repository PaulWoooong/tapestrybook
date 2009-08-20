package de.t5book.pages;

import java.util.Locale;

import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PersistentLocale;

public class ChooseLanguage {
	@Inject
	private PersistentLocale persistentLocale;
	
	void onActionFromDe(){
		persistentLocale.set(Locale.GERMAN);
	}
	
	void onActionFromEn(){
		persistentLocale.set(Locale.ENGLISH);
	}
}
