package de.t5book.mylib.components;

import org.apache.tapestry5.Asset;
import org.apache.tapestry5.MarkupWriter;
import org.apache.tapestry5.annotations.Path;
import org.apache.tapestry5.ioc.annotations.Inject;

public class TapestryLogo {
	@Inject
	@Path("tapestry.gif")
	private Asset logo;

	boolean beginRender(MarkupWriter writer) {
		writer.element("img", "src", logo);
		writer.end();

		return false;
	}
}