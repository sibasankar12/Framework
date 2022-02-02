package com.crm.Comcast.ContactTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.comcast.Objectrepolib.ContactInformation;
import com.crm.comcast.Objectrepolib.Contacts;
import com.crm.comcast.Objectrepolib.CreateNewContact;
import com.crm.comcast.Objectrepolib.CreateNewOrganization;
import com.crm.comcast.Objectrepolib.Home;
import com.crm.comcast.Objectrepolib.Organization;
import com.crm.comcast.Objectrepolib.OrganizationInformation;
import com.crm.generic.BaseClass;

@Listeners()
public class ContactContactTest extends BaseClass {
		   
			
			@Test(groups="smokeTest")
			public  void createcontactTest() throws Throwable 
			{
				String lastname = elib.getDataFromExcel("Sheet1", 7, 2);
				 /* step 02- Navigate to the contact page */
				  
				   Home h=new Home(driver);
				   h.getContactlink().click();
				   
				 /*  step 03 - Navigate to the create new contanct page*/
				   
				   Contacts c=new Contacts(driver);
				   wlib.waitUntilPageLoad(driver);
				   c.getCreateNewContactImg().click();
				   
				  
				 /* step 04 - create contanct */  
				   
				   CreateNewContact crtn= new CreateNewContact(driver);
				   crtn.createContact(lastname);
					
				     wlib.waitUntilPageLoad(driver);
				     
				  /* step 05-  Navigate to the contanctInformation page */ 
				    
				     ContactInformation ctin=new ContactInformation(driver);
				     String actconMsg = ctin.getContactHeaderMsg().getText();
		             
				     Assert.assertTrue( actconMsg.contains(lastname) );
			}
				   
			
			
			 @Test(groups="regressionTest")
			 public void CreateOrganizationWithContactTest() throws Throwable
			 {
				 int rndomnum = jlib.getRanDomnNumber();
				 String orgName = elib.getDataFromExcel("Sheet1", 10, 3)+rndomnum;
				 String lastname= elib.getDataFromExcel("Sheet1",10 ,2);
				 
				 /*  step 02 - Navigate to the organization page */
					Home h=new Home(driver);
					wlib.waitUntilPageLoad(driver);
					h.getOrglink().click();
					
					/*  step 03 - Navigate to the cretae new organization page*/
					Organization org=new Organization(driver);
					org.getCreateNewOrgImg().click();
					
					/*  step 04 - create the new organization*/
					CreateNewOrganization cr=new CreateNewOrganization(driver);
					cr.createOrg(orgName);
					
					/* step 05 - Navigate to the organizationInformation page*/
					OrganizationInformation orgin=new OrganizationInformation(driver);
					wlib.waitForElementVisibility(driver, orgin.getOrgHeaderSucMsg());
					
					Assert.assertTrue(orgin.getOrgHeaderSucMsg().getText().contains(orgName));
					
					/* step 06- Navigate to the contanct page*/
					 h.getContactlink().click();
					
					 /* step 07 - Navigate to  create new contanct page*/
					 Contacts c=new Contacts(driver);
					 c.getCreateNewContactImg().click();
					 
					/*  step 08 - create new contanct with lastname and the organization name*/
					 CreateNewContact crtn= new CreateNewContact(driver);
				     crtn.createContact(lastname, orgName);
				     
				     /* step 09 - Navigate to the contanctInformation page */
				     ContactInformation ctin=new ContactInformation(driver);
				     String actconMsg = ctin.getContactHeaderMsg().getText();
			        
				     /* step 10- compare between references  */
				     Assert.assertTrue(actconMsg.contains(lastname));
				     
				     String actOrgMsg=ctin.getOrginfo().getText();
				     System.out.println(actOrgMsg);
				     
				     SoftAssert sa=new SoftAssert();
				     sa.assertTrue(actOrgMsg.contains(orgName));
		             sa.assertAll();
		}
		
	}


