/**
 * 
 */
package springapp.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import springapp.service.PriceIncrease;
import springapp.service.ProductManager;

/**
 * @author migue
 * 
 * Controller class for PriceIncreaseForm...
 */
@SuppressWarnings("deprecation")
public class PriceIncreaseFormController extends SimpleFormController {
	
	protected final Log logger = LogFactory.getLog(this.getClass());
	
	private ProductManager productManager;
	
	
	public ModelAndView onSubmit(Object command) throws ServletException {
		
		int increase = ((PriceIncrease) command).getPercentage();
		logger.info("Increasing price by " + increase + "%");
		
		productManager.increasePrice(increase);
		
		logger.info("return from PriceIncreaseForm view to " + getSuccessView());
		
		return new ModelAndView(new RedirectView(getSuccessView()));
	}
	
	protected Object formBackingObject(HttpServletRequest request) throws ServletException {
		PriceIncrease priceIncrease = new PriceIncrease();
		priceIncrease.setPercentage(20);
		
		return priceIncrease;
	}

	public ProductManager getProductManager() {
		return productManager;
	}

	public void setProductManager(ProductManager productManager) {
		this.productManager = productManager;
	}
	
	
}
