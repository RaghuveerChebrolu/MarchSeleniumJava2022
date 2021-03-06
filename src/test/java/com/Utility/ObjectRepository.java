package com.Utility;

import com.Utility.constants;

public class ObjectRepository {

	public static final String GMO_OnlineCatalog= constants.xpath + "&"+"//h1[text()='OnLine Catalog']";
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
	
	public static final String DataDrivenFirstName = constants.xpath+"&"+"//input[@placeholder='First Name']";
	public static final String DataDrivenLastName = constants.xpath+"&"+"//input[@placeholder='Last Name']";
	public static final String DataDrivenAddress = constants.xpath+"&"+"//textarea[@ng-model='Adress']";
	public static final String DataDrivenEmailAddress = constants.xpath+"&"+"//input[@ng-model='EmailAdress']";
	public static final String DataDrivenPhone = constants.xpath+"&"+"//input[@ng-model='Phone']";
	public static final String DataDrivenMale = constants.xpath+"&"+"//input[@value='Male']";
	public static final String DataDrivenFeMale = constants.xpath+"&"+"//input[@value='FeMale']";
	
	public static final String DataDrivenCricket = constants.ID+"&"+"checkbox1";
	public static final String DataDrivenMovies = constants.ID+"&"+"checkbox2";
	public static final String DataDrivenHockey = constants.ID+"&"+"checkbox3";
	public static final String DataDrivenCloseIconOfLanguages = constants.xpath+"&"+"//span[@class='ui-icon ui-icon-close']";
	public static final String DataDrivenLanguages = constants.ID+"&"+"msdd";
	public static final String DataDrivenAllLanguages = constants.xpath+"&"+"//div[@id='msdd']/following-sibling::div/ul/li";
	public static final String DataDrivenFieldSkills = constants.xpath+"&"+"//*[text()='Skills']";
	public static final String DataDrivenSkills = constants.xpath+"&"+"//select[@id='Skills']";
	public static final String DataDrivenAllSkills = constants.xpath+"&"+"//select[@id='Skills']/option";
	public static final String DataDrivenSelectCountry = constants.xpath+"&"+"//span[@role='combobox']";
	public static final String DataDrivenTextBoxSelectCountry = constants.xpath+"&"+"//input[@type='search']";
	public static final String DataDrivenDOB_Year= constants.ID+"&"+"yearbox";
	public static final String DataDrivenDOB_ALLYears= constants.xpath+"&"+"//select[@id='yearbox']/option";
	public static final String DataDrivenDOB_Month= constants.xpath+"&"+"//select[@placeholder='Month']";
	public static final String DataDrivenDOB_ALLMonths = constants.xpath+"&"+"//select[@placeholder='Month']/option";
	public static final String DataDrivenDOB_Day = constants.xpath+"&"+"//select[@id='daybox']";
	public static final String DataDrivenDOB_ALLDays = constants.xpath+"&"+"//select[@id='daybox']/option";
	public static final String DataDrivenPWD = constants.ID+"&"+"firstpassword";
	public static final String DataDrivenConformPWD = constants.ID+"&"+"secondpassword";
	
	
	public static final String Links = constants.tagName+"&"+"a";
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
