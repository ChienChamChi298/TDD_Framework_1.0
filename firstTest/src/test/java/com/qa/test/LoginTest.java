package com.qa.test;

import org.testng.annotations.Test;

import com.qa.BaseTest;
import com.qa.page.LoginPage;
import com.qa.page.ProductPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.lang.reflect.Method;

import org.junit.Assert;
import org.testng.annotations.AfterClass;

public class LoginTest extends BaseTest { 
  LoginPage loginPage; 
  ProductPage productPage;
	

  
  @BeforeMethod
  public void beforeMethod(Method m) { 
	  loginPage = new LoginPage(); 
	  System.out.println("\n" + "******* Starting test: " + m.getName() + " ******** " + "\n");
	  
  }

  @AfterMethod
  public void afterMethod() {
  }
  @Test
  public void invaildUser() { 
	  loginPage.enterUserName("invaild_User"); 
	  loginPage.enterPassword("secret_sauce"); 
	  loginPage.pressLoginBtn();  
	  String actualErr = loginPage.errTxt(); 
	  String expectErr = "Username and password do not match any user in this service."; 
	  System.out.println("Actual err : "+ actualErr + "\n" + "Expect err : " + expectErr); 
	  Assert.assertEquals(expectErr, actualErr);
  }
 
  @Test
  public void invaildPassword() { 
	  loginPage.enterUserName("standard_user"); 
	  loginPage.enterPassword("invaild_password"); 
	  loginPage.pressLoginBtn();  
	  String actualErr = loginPage.errTxt(); 
	  String expectErr = "Username and password do not match any user in this service."; 
	  System.out.println("Actual err : "+ actualErr + "\n" + "Expect err : " + expectErr); 
	  Assert.assertEquals(expectErr, actualErr);
  }
  
  @Test
  public void successLogin() { 
	  loginPage.enterUserName("standard_user"); 
	  loginPage.enterPassword("secret_sauce"); 
	  productPage = loginPage.pressLoginBtn();  
	  String actualTitle = productPage.getTitle(); 
	  String expectTitle = "PRODUCTS";
	  System.out.println("Actual title : "+ actualTitle + "\n" + "Expect title : " + expectTitle); 
	  Assert.assertEquals(expectTitle, actualTitle);
  }
}
