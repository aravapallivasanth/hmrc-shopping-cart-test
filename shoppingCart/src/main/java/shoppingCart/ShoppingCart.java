/**
 * 
 */
package shoppingCart;

import java.util.List;
import java.util.Map;

/**
 * @author vasanth
 *
 */
public interface ShoppingCart {

	public Map<String, Long> addProducts(List<String> prodcutList);
	
	public Double calcuateTotalPrice(Map<String, Long> productMap);
}
