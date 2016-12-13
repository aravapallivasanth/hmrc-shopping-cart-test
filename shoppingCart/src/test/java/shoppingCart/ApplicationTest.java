/**
 * 
 */
package shoppingCart;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import exception.ShoppingCartException;

/**
 * @author vasanth
 *
 */
public class ApplicationTest {

	private static String[] productList_3Apple_1Orange = new String[]{"apple", "apple", "orange", "apple"};
	private static String[] productList_2Apple_3Orange = new String[]{"apple", "apple", "orange", "orange", "orange"};
	private static String[] productList_empty = new String[]{};
	private static String[] productList_invalid_products = new String[]{"banana", "pear"};
	
	@BeforeClass
	public static void setUpTestData() {	
		
	}
		
	@Test(expected = ShoppingCartException.class)
	public void calcualtePrice_Exception_For_EmptyList() throws ShoppingCartException{
		Application application = new Application();
		Double price = application.validateProductsAndCalculatePrice(Arrays.asList(productList_empty));		
	}
	
	@Test(expected = ShoppingCartException.class)
	public void calcualtePrice_Exception_For_InvalidProducts() throws ShoppingCartException{
		Application application = new Application();
		Double price = application.validateProductsAndCalculatePrice(Arrays.asList(productList_invalid_products));		
	}
	
	@Test
	public void calcualtePrice_ThreeApple_OneOrange(){
		Application application = new Application();
		Double price = 0.0;
		try {
			price = application.validateProductsAndCalculatePrice(Arrays.asList(productList_3Apple_1Orange));
		} catch (ShoppingCartException e) {
			// TODO: Need to use the Logger to log the exceptions.
			e.printStackTrace();
		}
		System.out.println(price);
		Assert.assertEquals(1.45, price, 0.001);
	}
	
	@Test
	public void calcualtePrice_TwoApple_ThreeOrange() {
		Application application = new Application();
		Double price = 0.0;
		try {
			price = application.validateProductsAndCalculatePrice(Arrays.asList(productList_2Apple_3Orange));
		} catch (ShoppingCartException e) {
			// TODO: Need to use the Logger to log the exceptions.
			e.printStackTrace();
		}
		System.out.println(price);
		Assert.assertEquals(1.10, price, 0.001);
	}
}
