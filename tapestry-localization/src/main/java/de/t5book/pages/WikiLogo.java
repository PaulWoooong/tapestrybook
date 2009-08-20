package de.t5book.pages;

import org.apache.tapestry5.Asset;
import org.apache.tapestry5.annotations.Path;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

public class WikiLogo {
	@Inject
	@Path("wiki.png")
	@Property
	private Asset wikiLogo;
}
