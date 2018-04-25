package de.hybris.platform.warehousing.atp.strategy.impl;

import de.hybris.platform.ordersplitting.model.StockLevelModel;
import de.hybris.platform.warehousing.atp.dao.CustomAvailableToPromiseDao;
import org.springframework.beans.factory.annotation.Required;

import java.util.Collection;
import java.util.Map;

public class CustomAvailabilityCalculationStrategy extends WarehousingAvailabilityCalculationStrategy {
	private CustomAvailableToPromiseDao availableToPromiseDao;

	@Override
	public Long calculateAvailability(final Collection<StockLevelModel> stockLevels) {
		if (stockLevels.isEmpty()) {
			return 0L;
		}
		final Map<String, Object> params = null; // setupParameters(stockLevels);
/*		return getAvailableToPromiseDao().getAvailabilityForStockLevels(params)
				- getAvailableToPromiseDao().getAllocationQuantityForStockLevels(params)
				+ getAvailableToPromiseDao().getCancellationQuantityForStockLevels(params)
				- getAvailableToPromiseDao().getReservedQuantityForStockLevels(params)
				+ getAvailableToPromiseDao().getOversellingQuantityForStockLevels(params);*/
return null;

	}

	@Required
	public void setAvailableToPromiseDao(CustomAvailableToPromiseDao availableToPromiseDao) {
		this.availableToPromiseDao = availableToPromiseDao;
	}
}