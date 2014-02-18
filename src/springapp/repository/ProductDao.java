/**
 * 
 */
package springapp.repository;

import java.util.List;

import springapp.domain.Product;

/**
 * @author migue
 * Interface for Product DAO...
 */
public interface ProductDao {

	public List<Product> getProductList();
	
	public void saveProduct(Product product);
}
