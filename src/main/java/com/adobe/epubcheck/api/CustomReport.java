package com.adobe.epubcheck.api;

/*
 * hyeyeong - customized report class for test
 */

import java.io.File;
import java.io.IOException;

import com.adobe.epubcheck.reporting.CheckingReport;
import com.adobe.epubcheck.util.ReportingLevel;

public class CustomReport
{
	private String path;
	private File fileOut;
	private int reportingLevel = ReportingLevel.Info;
	
	public CustomReport(String path, File fileOut)
	{
		path = this.path;
		fileOut = this.fileOut;
	}
	
	public Report createReport() throws IOException
	{
		Report report;
		report = new CheckingReport(path, (fileOut == null) ? null : fileOut.getPath());
		report.setReportingLevel(this.reportingLevel);
		
		return report;
	}
}
