package de.t5book.pages;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.tapestry5.StreamResponse;
import org.apache.tapestry5.services.Response;

import com.lowagie.text.Document;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

public class PdfPage {

	public StreamResponse onAction() {

		return new StreamResponse() {

			public String getContentType() {
				return "application/pdf";
			}

			public InputStream getStream() throws IOException {
				return createPdf();
			}

			public void prepareResponse(final Response response) {
				response.setHeader("Content-disposition",
						"attachment;filename=Tapestry.pdf");

			}

		};
	}

	public InputStream createPdf() {
		Document document = new Document();
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		try {
			PdfWriter.getInstance(document, stream);
			document.open();
			document.add(new Paragraph(
					"Erzeugung einer PDF-Datei mit Tapestry und iText."));
			URL url = getClass().getResource("tapestry_logo.png");
			document.add(Image.getInstance(url));
		} catch (final Exception e) {
			throw new RuntimeException(e);
		}
		document.close();
		return new ByteArrayInputStream(stream.toByteArray());
	}

}