package com.adobe.epubcheck.api;

import java.io.File;

import com.adobe.epubcheck.ctc.xml.HTMLTagsAnalyseHandler;
import com.adobe.epubcheck.ctc.xml.XMLContentDocParser;
import com.adobe.epubcheck.util.EPUBVersion;


public class EpubCheckStarter
{	
    public static void main(String[] args)
    {
        String filePath = "/Users/hyeyeong/Section0006.xhtml";
        File epubFile = new File(filePath);
        Report report = null;
        //EpubCheck epubCheck = new EpubCheck(epubFile);
        //epubCheck.validate();
        HTMLTagsAnalyseHandler htmlHandler = new HTMLTagsAnalyseHandler();
        htmlHandler.setFileName(filePath);
        htmlHandler.setVersion(EPUBVersion.VERSION_3);
        //htmlHandler.startDocument();
        
        XMLContentDocParser xmlParser = new XMLContentDocParser(filePath, report, null);
        xmlParser.parseDoc(filePath, htmlHandler);
    }
}
