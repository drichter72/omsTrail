package de.hybris.platform.warehousing.atp.dao.impl;

import de.hybris.platform.ordersplitting.model.StockLevelModel;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.warehousing.atp.dao.CustomAvailableToPromiseDao;

import java.util.Map;

public class DefaultCustomAvailableToPromiseDao extends DefaultAvailableToPromiseDao implements CustomAvailableToPromiseDao {
	@Override
	public Long getOversellingQuantityForStockLevels(final Map<String, Object> params) {


		final StringBuilder stockLevelQryString = new StringBuilder();
		stockLevelQryString.append("SELECT SUM({" + StockLevelModel.OVERSELLING + "}) FROM {" + StockLevelModel._TYPECODE
				+ "} WHERE {" + StockLevelModel.PK + "} IN (?stockLevels)");

		//key einfach zugefügt
		return returnAggregateQuantity(stockLevelQryString.toString(), params, "key");
	}
}