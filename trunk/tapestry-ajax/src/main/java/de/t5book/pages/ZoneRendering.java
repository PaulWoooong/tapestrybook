package de.t5book.pages;

import org.apache.tapestry5.MarkupWriter;
import org.apache.tapestry5.Renderable;
import org.apache.tapestry5.ajax.MultiZoneUpdate;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.corelib.components.TextOutput;
import org.apache.tapestry5.runtime.RenderCommand;
import org.apache.tapestry5.runtime.RenderQueue;

public class ZoneRendering {

	@Component(parameters = "value=literal:Von TextOutput erzeugt.")
	private TextOutput textOutput;

	Object onAction() {

		Renderable renderable = new Renderable() {
			public void render(MarkupWriter writer) {
				writer.write("Von Renderable erzeugt.");

			}

		};

		RenderCommand command = new RenderCommand() {

			public void render(MarkupWriter writer, RenderQueue queue) {
				writer.write("Von RenderCommand erzeugt.");
			}

		};

		return new MultiZoneUpdate("string", "Dies ist ein String").add(
				"component", textOutput).add("renderable", renderable).add(
				"rendercommand", command);
	}
}
