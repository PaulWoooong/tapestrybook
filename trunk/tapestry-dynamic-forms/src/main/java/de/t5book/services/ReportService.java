package de.t5book.services;

import java.io.InputStream;
import java.util.List;

import de.t5book.entities.ReportParameter;

public interface ReportService {
	
	List<ReportParameter> getReportParameters(String reportName);
	
	ReportParameter findReportParameter(String reportName, String name);
	
	InputStream getReportData(String reportName, List<ReportParameter> parameters);
}
