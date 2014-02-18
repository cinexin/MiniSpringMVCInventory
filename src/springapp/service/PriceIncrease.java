/**
 * 
 */
package springapp.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author migue
 * JavaBean for "PriceIncrease" form...
 */
public class PriceIncrease {
	
	protected  final Log logger = LogFactory.getLog( this.getClass());
	
	private int percentage;

	public int getPercentage() {
		return percentage;
	}

	public void setPercentage(int percentage) {
		logger.info("Percentage set to " + percentage);
		this.percentage = percentage;
	}
	
	
}
