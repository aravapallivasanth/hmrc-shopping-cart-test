/**
 * 
 */
package shoppingCart;

import inventory.Inventory;
import inventory.InventoryImpl;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import exception.ShoppingCartException;

/**
 * @author vasanth
 * This class is the main entry point for the shopping cart functionality.
 */
public class Application {

	//TODO: We can use Spring Autowire to inject the dependencies
	//TODO: We can easily convert this Applicaiton.java into Spring Boot application.
	//Inventory inventory;
	
	public Double validateProductsAndCalculatePrice(List<String> products) throws ShoppingCartException {
		Double price = 0.0 ;
		if (products.size()<=0)
			throw new ShoppingCartException("Please supply the products for shopping cart");
		else {
			//TODO: We can use Spring to inject the dependencies instead manually creating the objects.
			Inventory inventory = new InventoryImpl();			
			Predicate<String> productPredicate = s -> inventory.availableProductsForSale().contains(s);			
			if (products.stream().allMatch(productPredicate)){
				ShoppingCart shoppingCart = new ShoppingCartImpl();
				Map<String, Long> productMap = shoppingCart.addProducts(products);
				price = shoppingCart.calcuateTotalPrice(productMap);				
			} else {
				throw new ShoppingCartException("We only sells Apples and Oranges");
			}			
		}
		return price;		
	}
}
