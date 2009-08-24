package de.t5book.components;

import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.MarkupWriter;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.SupportsInformalParameters;
import org.apache.tapestry5.ioc.annotations.Inject;

@SupportsInformalParameters
public class HtmlLinkComponent {
	@Parameter(required = true, defaultPrefix = BindingConstants.LITERAL)
	private String href;

	@Inject 
	private ComponentResources resources;

	void beginRender(MarkupWriter writer) {
		writer.element("a", "href", href);
		resources.renderInformalParameters(writer);
	}

	void afterRender(MarkupWriter writer) {
		writer.end();
	}
}
