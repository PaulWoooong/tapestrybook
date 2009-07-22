package de.t5book.pages;

import java.util.GregorianCalendar;

import de.t5book.entities.Gender;
import de.t5book.entities.User;

public class BeanDisplayDemo {
	
	public User getUser(){
		User user = new User("root", "secret");
		user.setId(123l);
		user.setEmail("test@example.com");
		user.setBirthday(new GregorianCalendar(1978,3,6).getTime());
		user.setGender(Gender.MALE);
		user.setSubscribeNewsletter(true);
		return user;
	}
}
