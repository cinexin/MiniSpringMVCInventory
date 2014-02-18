/**
 * 
 */
package springapp.service;

import java.util.List;

import springapp.domain.Product;
import springapp.repository.ProductDao;

/**
 * @author migue
 *
 */
public class SimpleProductManager implements ProductManager {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7010821624164052421L;
	// private List<Product> products;
	private ProductDao productDao;
	
	/* (non-Javadoc)
	 * @see springapp.service.ProductManager#increasePrice(int)
	 */
	@Override
	public void increasePrice(int percentage) {
		List<Product> products = productDao.getProductList();
		 if (products != null) {
			for (Product product:products) {
				double newPrice = product.getPrice().doubleValue()  * (100+percentage)/100;
				product.setPrice(newPrice);
				productDao.saveProduct(product);
			}
		}


	}

	/* (non-Javadoc)
	 * @see springapp.service.ProductManager#getProducts()
	 */
	@Override
	public List<Product> getProducts() {
		return productDao.getProductList();
		
	}
	
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	/* public void setProducts(List<Product> products) {
		this.products = products;
	}*/

}
