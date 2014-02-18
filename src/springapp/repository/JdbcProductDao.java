/**
 * 
 */
package springapp.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

import springapp.domain.Product;

/**
 * @author migue
 * JDBC implementation for Product DAO
 */
@SuppressWarnings("deprecation")
public class JdbcProductDao extends SimpleJdbcDaoSupport implements ProductDao {

	protected final Log logger = LogFactory.getLog(this.getClass());
	
	
	/* (non-Javadoc)
	 * @see springapp.repository.ProductDao#getProductList()
	 */
	@Override
	public List<Product> getProductList() {
		logger.info("Getting products from DAO...");
		List<Product> products = getSimpleJdbcTemplate().query("SELECT id,  description,  price FROM products", new ProductMapper());
		
		return products;
	}

	/* (non-Javadoc)
	 * @see springapp.repository.ProductDao#saveProduct(springapp.domain.Product)
	 */
	@Override
	public void saveProduct(Product product) {
		logger.info("Saving product from DAO: " + product.getDescription());
		String sql = "UPDATE products SET description=:description, price = :price where id = :id";
		MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("description", product.getDescription());
		sqlParameterSource.addValue("price", product.getPrice());
		sqlParameterSource.addValue("id", product.getId());
		int count = getSimpleJdbcTemplate().update(sql, sqlParameterSource);
		logger.info("Rows affected: " + count);

	}
	
	/* inner class for Product parameter mapping...*/
	
	private static class ProductMapper implements ParameterizedRowMapper<Product> {

		@Override
		public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
			Product product = new Product();
			product.setId(rs.getInt("id"));
			product.setDescription(rs.getString("description"));
			product.setPrice(rs.getDouble("price"));
			return product;
		}
		
	}

}
