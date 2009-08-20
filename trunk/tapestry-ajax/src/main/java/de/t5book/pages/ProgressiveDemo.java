package de.t5book.pages;

import org.apache.tapestry5.Block;
import org.apache.tapestry5.MarkupWriter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.runtime.RenderCommand;
import org.apache.tapestry5.runtime.RenderQueue;

public class ProgressiveDemo {
	@Inject
	private Block content;

	Object onProgressiveDisplayFromTwoSecondsDelay() {
		sleep(2000);
		return this.content;
	}

	Object onProgressiveDisplayFromOneSecondDelay() {
		sleep(1000);
		return new RenderCommand() {
			public void render(MarkupWriter writer, RenderQueue queue) {
				writer.write("Dieser Inhalt wurde nachgeladen.");
			}
		};
	}

	public static void sleep(final int millis) {
		try {
			Thread.sleep(millis);
		} catch (final Exception ex) {
		}
	}
}
