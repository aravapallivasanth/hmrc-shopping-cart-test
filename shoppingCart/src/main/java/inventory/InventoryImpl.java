package inventory;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author vasanth
 *
 */
public class InventoryImpl implements Inventory {

	@Override
	public Set<String> availableProductsForSale() {
		return getAllInventory().keySet();
	}
	
	@Override
	public Map<String,Double> getAllInventory(){
		Map<String,Double> inventroy = new HashMap<>();
		inventroy.put("apple",0.60);
		inventroy.put("orange",0.25);		
		return inventroy;		
	}
	
	@Override
	public Double getProductPrice(String productName){
		return getAllInventory().get(productName);
	}

}
