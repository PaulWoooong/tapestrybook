package de.t5book.services.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

import de.t5book.entities.DateParameter;
import de.t5book.entities.NumericParameter;
import de.t5book.entities.ReportParameter;
import de.t5book.entities.StringParameter;
import de.t5book.services.ReportService;

public class ReportServiceImpl implements ReportService {

	public InputStream getReportData(String reportName,
			List<ReportParameter> parameters) {
		Document document = new Document();
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		try {
			PdfWriter.getInstance(document, stream);
			document.open();
			document.add(new Paragraph(String
					.format("Bericht '%s'", reportName)));
			for (ReportParameter param : parameters) {
				document.add(new Paragraph(String.format("Parameter %s:%s",
						param.getName(), param.getValue())));
			}

		} catch (final Exception e) {
			throw new RuntimeException(e);
		}
		document.close();
		return new ByteArrayInputStream(stream.toByteArray());
	}

	public List<ReportParameter> getReportParameters(String reportName) {

		ReportParameter date = new StringParameter("Wertpapier");
		ReportParameter number = new NumericParameter("Börsencode");
		ReportParameter text = new DateParameter("Stichtag");

		return Arrays.asList(date, number, text);
	}

	public ReportParameter findReportParameter(String reportName, String name) {
		List<ReportParameter> parameters = getReportParameters(reportName);
		
		for (ReportParameter next : parameters) {
			if (next.getName().equals(name)) {
				return next;
			}
		}
		return null;
	}

}
