package de.t5book.pages;

import org.apache.tapestry5.annotations.Property;

public class MyPage {
	@Property
	private Long userId;

	@Property
	private Long bookId;

	void onActivate(Long userId, Long bookId) {
		System.err.println("userId = " + userId);
		System.err.println("bookId = " + bookId);
	}
}
