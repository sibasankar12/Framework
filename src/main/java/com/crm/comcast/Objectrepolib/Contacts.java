package com.crm.comcast.Objectrepolib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contacts {

	WebDriver driver;
	/**
	 * this is used to intiate the element
	 * @param driver
	 */
		public Contacts(WebDriver driver) 
		{
		this.driver=driver;
		PageFactory.initElements( driver,this);

	}
		
		
		@FindBy(xpath="//img[@title='Create Contact...']")
		private WebElement createNewContactImg;
		
		
		public WebElement getCreateNewContactImg() {
			return createNewContactImg;
		}

}







