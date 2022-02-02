package com.crm.comcast.Objectrepolib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformation {
	WebDriver driver;
	/**
	 * this is used to initialise the element
	 * @param driver
	 */
		public OrganizationInformation(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements( driver,this);
	}
	 @FindBy(xpath="//span[@class='dvHeaderText']")
	 private WebElement orgHeaderSucMsg;
	 
	 @FindBy(id="dtlview_Industry")
	 private WebElement industriesInfo;
	 
	 @FindBy(id="dtlview_Type")
	 private WebElement typelistInfo;

	 
	 public WebElement getOrgHeaderSucMsg() {
		return orgHeaderSucMsg;
	}

	public WebElement getIndustriesInfo() {
		return industriesInfo;
	}

	public WebElement getTypelistInfo() {
		return typelistInfo;
	}
	 


	 
	}

