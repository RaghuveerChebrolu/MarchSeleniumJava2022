package com.Utility;

public class ObjectRepository {

	public static final String textBoxFrame = constants.xpath+"&"+"//input[@type='text']";
	public static final String FrameWithInframeButton = constants.xpath+"&"+"//*[text()='Iframe with in an Iframe']";
	public static final String MultipleFrames = constants.xpath+"&"+"//iframe[@src='MultipleFrames.html']";
	public static final String SingleFrame = constants.xpath+"&"+"//iframe[@src='SingleFrame.html']";
	public static final String NewBrowserWindow = constants.Name+"&"+"newbrowserwindow123";
	public static final String MenuInsideNew_BrowserWindow = constants.xpath+"&"+"//span[@class='oceanwp-text']";
	public static final String AboutMeInNewbrowserWindow = constants.xpath+"&"+"(//a[text()='About Me'])[1]";
	public static final String TechTalkInsideNewbrowserWindow = constants.xpath+"&"+"(//a[text()='TechTalk'])[1]";
	
	
	
	
	
	

}
