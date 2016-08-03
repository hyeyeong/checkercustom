package com.adobe.epubcheck.api;


import java.io.File;

import com.adobe.epubcheck.ctc.xml.HTMLTagsAnalyseHandler;
import com.adobe.epubcheck.ctc.xml.XMLContentDocParser;
import com.adobe.epubcheck.util.EPUBVersion;
import com.twelvemonkeys.io.FileUtil;

public class AccessibilityCheckHelper {
	private final EPUBVersion EPUB3 = EPUBVersion.VERSION_3;
	private final String testFilePath = "/Users/hyeyeong/Section0006.xhtml";
	//private final String testReportPath = "/Users/hyeyeong/accreport.json";
	private final int XHTML = 1;
	private final int CSS = 2;
	private final int SVG = 3;

	private String filePath;
	private String fileExt;
	private Report accessibilityReport;
	
	public AccessibilityCheckHelper() {
		this.filePath = testFilePath;
		this.fileExt = "xhtml";
		this.accessibilityReport = null;
	}
	
	public AccessibilityCheckHelper(File unitFile) {
		this.filePath = unitFile.getPath();
		this.fileExt = FileUtil.getExtension(unitFile);
		this.accessibilityReport = null;
	}
	
	public void checkAccessibility() {
		HTMLTagsAnalyseHandler htmlHandler = new HTMLTagsAnalyseHandler();
		XMLContentDocParser xmlParser;
		
		htmlHandler.setVersion(EPUB3);
		htmlHandler.setFileName(filePath);
		
		switch (getFileExtension())
		{
			case XHTML:
				xmlParser = new XMLContentDocParser(filePath, accessibilityReport, null);
				xmlParser.parseDoc(filePath, htmlHandler);
			break;
			
			case CSS:
				System.out.println("css file check");
			break;
			
			case SVG:
				System.out.println("svg file check");
			break;
			
			default:
				System.out.println("not unit file");
			break;
		}
	}
	
	private int getFileExtension() {
		if (fileExt.equals("xhtml"))
			return XHTML;
		else if (fileExt.equals("css"))
			return CSS;
		else if (fileExt.equals("svg"))
			return SVG;
		else
			return 0;
	}
	
	/*private Report createReport() throws IOException {
		Report report = new CheckingReport(path, (fileOut == null) ? null : fileOut.getPath());
		return report;
	}*/
}
