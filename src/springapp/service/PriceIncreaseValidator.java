/**
 * 
 */
package springapp.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @author migue
 * "Validator" class for PriceIncrease form...
 */
public class PriceIncreaseValidator implements Validator {

	private int DEFAULT_MIN_PERCENTAGE = 0;
	private int DEFAULT_MAX_PERCENTAGE = 50;
	
	private int minPercentage = DEFAULT_MIN_PERCENTAGE;
	private int maxPercentage = DEFAULT_MAX_PERCENTAGE;
	
	protected final Log logger = LogFactory.getLog(this.getClass());
	
	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#supports(java.lang.Class)
	 */
	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return true;
	}

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#validate(java.lang.Object, org.springframework.validation.Errors)
	 */
	@Override
	public void validate(Object obj, Errors errors) {
		PriceIncrease priceInc = (PriceIncrease) obj;
		if (priceInc==null) {
			errors.rejectValue("percentage", "error.not-specified", null, "Value required.");
		} else {
			logger.info("Validating with " + priceInc + ": " + priceInc.getPercentage());
			if (priceInc.getPercentage() > maxPercentage) {
				errors.rejectValue("percentage", "error.too-high",new Object[] {new Integer(maxPercentage)},"Value too high.");
			}
			
			if (priceInc.getPercentage() < minPercentage) {
				errors.rejectValue("percentage", "error.too-low",new Object[] {new Integer(minPercentage)},"Value too low.");
			}
		}

	}

	public int getMinPercentage() {
		return minPercentage;
	}

	public void setMinPercentage(int minPercentage) {
		this.minPercentage = minPercentage;
	}

	public int getMaxPercentage() {
		return maxPercentage;
	}

	public void setMaxPercentage(int maxPercentage) {
		this.maxPercentage = maxPercentage;
	}

}
