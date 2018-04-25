package de.hybris.platform.warehousing.atp.dao;

import java.util.Map;

public interface CustomAvailableToPromiseDao extends AvailableToPromiseDao{

	/**
	 * Get the overselling quantity of a certain product for a collection of stock levels
	 *
	 * @param params
	 *           the parameters required to perform the search
	 * @return the quantity of product to oversell
	 */
	Long getOversellingQuantityForStockLevels(Map<String, Object> params);
}
