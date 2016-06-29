package com.adobe.epubcheck.api;

import com.adobe.epubcheck.ctc.xml.HTMLTagsAnalyseHandler;
import com.adobe.epubcheck.util.EPUBVersion;


public class EpubCheckStarter
{	
    public static void main(String[] args)
    {
        String filePath = "~/Documents/workspace/Section0005.xhtml";
        //File epubFile = new File(filePath); 
        //EpubCheck epubCheck = new EpubCheck(epubFile);
        //epubCheck.validate();
        HTMLTagsAnalyseHandler htmlHandler = new HTMLTagsAnalyseHandler();
        htmlHandler.setFileName(filePath);
        htmlHandler.setVersion(EPUBVersion.VERSION_3);
        //htmlHandler.startDocument();
        
        //XMLContentDocParser xmlParser = new XMLContentDocParser();
    }
}
