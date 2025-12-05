package com.academy.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.academy.TestComponents.BaseTest;
import com.academy.TestComponents.Retry;
import com.academy.pageobjects.CartPage;
import com.academy.pageobjects.ProductCatalogue;

public class ErrorValidationsTest extends BaseTest {

	@Test(groups= {"ErrorHandling"},retryAnalyzer=Retry.class)
	public void LoginErrorValidation() throws IOException, InterruptedException {

	
		landingPage.loginApplication("test.user101@xyz.com", "Test@12345");
		Assert.assertEquals("Incorrect email or password..", landingPage.getErrorMessage());

	}
	

	@Test
	public void ProductErrorValidation() throws IOException, InterruptedException
	{

		String productName = "ZARA COAT 3";
		ProductCatalogue productCatalogue = landingPage.loginApplication("test.user101@xyz.com", "Test@1234");
		//List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		CartPage cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.VerifyProductDisplay("ZARA COAT 33");
		Assert.assertFalse(match);
		
	

	}

	
	

}
