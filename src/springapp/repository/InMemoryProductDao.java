/**
 * 
 */
package springapp.repository;

import java.util.List;

import springapp.domain.Product;

/**
 * @author migue
 * we want this to make tests without using the real DAO
 */
public class InMemoryProductDao implements ProductDao {

	private List<Product> productList;
	
	
	public InMemoryProductDao(List<Product> productList) {
		this.productList = productList;
	}
	
	/* (non-Javadoc)
	 * @see springapp.repository.ProductDao#getProductList()
	 */
	@Override
	public List<Product> getProductList() {
		return this.productList;
	}

	/* (non-Javadoc)
	 * @see springapp.repository.ProductDao#saveProduct(springapp.domain.Product)
	 */
	@Override
	public void saveProduct(Product product) {


	}

}
