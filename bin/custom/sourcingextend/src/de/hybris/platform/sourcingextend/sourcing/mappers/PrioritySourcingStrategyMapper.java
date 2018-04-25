package de.hybris.platform.sourcingextend.sourcing.mappers;

import de.hybris.platform.warehousing.data.sourcing.SourcingContext;
import de.hybris.platform.warehousing.data.sourcing.SourcingLocation;
import de.hybris.platform.warehousing.sourcing.strategy.AbstractSourcingStrategyMapper;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PrioritySourcingStrategyMapper extends AbstractSourcingStrategyMapper {

	private static final Logger LOG = LoggerFactory.getLogger(PrioritySourcingStrategyMapper.class);

	@Override
	public Boolean isMatch(SourcingContext context) {

		if (CollectionUtils.isEmpty(context.getOrderEntries())) {
			return Boolean.FALSE;
		}

		for (SourcingLocation sourcingLocation : context.getSourcingLocations()) {
			if (sourcingLocation.getWarehouse().getPriority() != null) {
				LOG.debug("Match found for context!");
				return Boolean.TRUE;
			}
		}

		return Boolean.FALSE;
	}
}
