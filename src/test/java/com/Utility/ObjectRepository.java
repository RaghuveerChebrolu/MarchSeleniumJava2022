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
	
	public static final String MouseOpearationRightcClick = constants.xpath+"&"+"//span[text()='right click me']";
	public static final String MouseOpearationPasteOption = constants.xpath+"&"+"//span[text()='Paste']";
	
	public static final String MouseOperationFrame = constants.xpath+"&"+"//iframe";
	public static final String MouseOperationDoubleClickBox = constants.xpath+"&"+"//span[text()='Double click the block']/preceding-sibling::div";
	
	public static final String MouseOperationDrag = constants.ID+"&"+"draggable";
	public static final String MouseOperationDrop = constants.ID+"&"+"droppable";
	
	public static final String WebTableLastNames = constants.xpath+"&"+"//table[@id='example']/tbody/tr/td[3]";
	
	public static final String FileUploadBrowseButton = constants.xpath+"&"+"//input[@id='input-4']/preceding-sibling::span";
	public static final String FileUploadRemoveButton = constants.xpath+"&"+"//span[text()='Remove']";
	public static final String FileDownload500KBFile = constants.xpath+"&"+"//table/tbody/tr[2]/td[5]/a";
	
	
	
	
	
	
	
	
	

}
