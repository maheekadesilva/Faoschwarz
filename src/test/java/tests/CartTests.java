package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;
import pages.SearchResults;

public class CartTests extends BaseClass {
	
	@Test
	public void testValidateCartDetails() {
		HomePage homePage = new HomePage(driver);
		SearchResults searchResults = new SearchResults(driver);
		ProductPage productDetails = new ProductPage(driver);
		CartPage cartActions = new CartPage(driver);
		
		homePage.closePromo();
		homePage.clickSearchBtn();
		homePage.performSearch("car");
		homePage.clickonSearchOutput();
		searchResults.closeCookieBanner();
		searchResults.performSort();
		searchResults.selectProduct();
		productDetails.changeQty();
		productDetails.addProductToCart();
		String productDetailsTitle = productDetails.getProductTitle();
		String productDetailsPrice = productDetails.getProductprice();
		cartActions.viewCart();
		String cartProductTitle = cartActions.getProductTitle();
		String cartProductPrice = cartActions.getProductprice();
		
		Assert.assertEquals(productDetailsTitle, cartProductTitle);
		Assert.assertEquals(productDetailsPrice, cartProductPrice);
	}
	

}
