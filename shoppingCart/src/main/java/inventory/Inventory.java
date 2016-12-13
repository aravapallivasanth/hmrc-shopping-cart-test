/**
 * 
 */
package inventory;

import java.util.Map;
import java.util.Set;

/**
 * @author vasanth
 *
 */
public interface Inventory {
	public Set<String> availableProductsForSale();
	public Map<String,Double> getAllInventory();
	public Double getProductPrice(String productName);
}
