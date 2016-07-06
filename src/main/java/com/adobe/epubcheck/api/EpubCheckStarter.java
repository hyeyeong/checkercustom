package com.adobe.epubcheck.api;

/*
 * hyeyeong - main class for test
 */

import com.adobe.epubcheck.ctc.xml.HTMLTagsAnalyseHandler;
import com.adobe.epubcheck.ctc.xml.XMLContentDocParser;
import com.adobe.epubcheck.util.EPUBVersion;


public class EpubCheckStarter
{
    public static void main(String[] args) throws Exception
    {
        String filePath = "/Users/hyeyeong/Section0006.xhtml";
        
        HTMLTagsAnalyseHandler htmlHandler = new HTMLTagsAnalyseHandler();
        htmlHandler.setFileName(filePath);
        htmlHandler.setVersion(EPUBVersion.VERSION_3);
        
        Report report = null;
        XMLContentDocParser xmlParser = new XMLContentDocParser(filePath, report, null);
        xmlParser.parseDoc(filePath, htmlHandler);
    }
}
