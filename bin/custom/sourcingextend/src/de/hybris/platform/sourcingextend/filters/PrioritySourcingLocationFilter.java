package de.hybris.platform.sourcingextend.filters;

import de.hybris.platform.core.model.order.AbstractOrderModel;
import de.hybris.platform.ordersplitting.model.WarehouseModel;
import de.hybris.platform.warehousing.sourcing.filter.impl.AbstractBaseSourcingLocationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Random;
import java.util.Set;

public class PrioritySourcingLocationFilter extends AbstractBaseSourcingLocationFilter {
	private static final Logger LOG = LoggerFactory.getLogger(PrioritySourcingLocationFilter.class);


	@Override
	public Collection<WarehouseModel> applyFilter(AbstractOrderModel order, Set<WarehouseModel> locations) {
			LOG.debug("initialisieren!");
			locations.stream().filter(location -> location.getPriority() == null).forEach(location -> location.setPriority(new Random().nextInt(101)));
		return locations;
	}
}
