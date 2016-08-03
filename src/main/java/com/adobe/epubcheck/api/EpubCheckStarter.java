package com.adobe.epubcheck.api;

public class EpubCheckStarter
{
    public static void main(String[] args) throws Exception
    {
        AccessibilityCheckHelper accHelper = new AccessibilityCheckHelper();
        accHelper.checkAccessibility();
    }
}
