package de.t5book.pages;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.Link;
import org.apache.tapestry5.StreamResponse;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.Response;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;

public class ChartPage {
	@Inject
	private ComponentResources componentResources;

	public Link getChartSrc() {
		return this.componentResources.createEventLink("chart");
	}

	StreamResponse onChart() {
		return new StreamResponse() {

			public String getContentType() {
				return "image/jpeg";
			}

			public InputStream getStream() throws IOException {
				final JFreeChart chart = createChart();
				final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				ChartUtilities.writeChartAsJPEG(outputStream, chart, 400, 300);
				return new ByteArrayInputStream(outputStream.toByteArray());

			}

			public void prepareResponse(final Response response) {
			}

		};
	}

	private JFreeChart createChart() {
		final DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("Java", new Double(43.2));
		dataset.setValue("Visual Basic", new Double(10.0));
		dataset.setValue("PHP", new Double(32.5));
		dataset.setValue("Perl", new Double(1.0));
		dataset.setValue("C/C++", new Double(17.5));


		final PiePlot3D plot = new PiePlot3D(dataset);
		plot.setForegroundAlpha(0.5f);
		plot.setCircular(true);
		plot.setStartAngle(290);
		plot.setDepthFactor(0.15);


		return new JFreeChart(plot);
	}
}