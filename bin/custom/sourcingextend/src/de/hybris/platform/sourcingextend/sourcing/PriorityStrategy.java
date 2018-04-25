package de.hybris.platform.sourcingextend.sourcing;

import com.google.common.base.Preconditions;
import de.hybris.platform.warehousing.data.sourcing.SourcingContext;
import de.hybris.platform.warehousing.data.sourcing.SourcingLocation;
import de.hybris.platform.warehousing.sourcing.strategy.AbstractSourcingStrategy;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class PriorityStrategy extends AbstractSourcingStrategy {
	@Override
	public void source(SourcingContext sourcingContext) {
		Preconditions.checkArgument(Objects.nonNull(sourcingContext), "Parameter sourcingContext cannot be null");
		//list of sourcinglocaction from sourcingcontext stream . collect Collectors.tolist

		List<SourcingLocation> sortByPriority = sourcingContext.getSourcingLocations().stream().collect(Collectors.toList());

		Collections.sort(sortByPriority, (e1, e2) -> Integer.compare(e1.getPriority(), e2.getPriority()));
		Collections.reverse(sortByPriority);
		final Optional<SourcingLocation> bestMatch = sortByPriority.stream().findFirst();
		bestMatch.ifPresent(bestLocation -> sourcingContext.getResult().getResults().add(getSourcingResultFactory().create(sourcingContext.getOrderEntries(), bestLocation)));
		final boolean checkSourceCompleted = checkSourceCompleted(sourcingContext);
		sourcingContext.getResult().setComplete(checkSourceCompleted);
	}
}
