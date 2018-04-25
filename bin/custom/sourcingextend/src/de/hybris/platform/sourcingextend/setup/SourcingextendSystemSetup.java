/*
 * [y] hybris Platform
 *
 * Copyright (c) 2017 SAP SE or an SAP affiliate company.  All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.sourcingextend.setup;

import static de.hybris.platform.sourcingextend.constants.SourcingextendConstants.PLATFORM_LOGO_CODE;

import de.hybris.platform.core.initialization.SystemSetup;

import java.io.InputStream;

import de.hybris.platform.sourcingextend.constants.SourcingextendConstants;
import de.hybris.platform.sourcingextend.service.SourcingextendService;


@SystemSetup(extension = SourcingextendConstants.EXTENSIONNAME)
public class SourcingextendSystemSetup
{
	private final SourcingextendService sourcingextendService;

	public SourcingextendSystemSetup(final SourcingextendService sourcingextendService)
	{
		this.sourcingextendService = sourcingextendService;
	}

	@SystemSetup(process = SystemSetup.Process.INIT, type = SystemSetup.Type.ESSENTIAL)
	public void createEssentialData()
	{
		sourcingextendService.createLogo(PLATFORM_LOGO_CODE);
	}

	private InputStream getImageStream()
	{
		return SourcingextendSystemSetup.class.getResourceAsStream("/sourcingextend/sap-hybris-platform.png");
	}
}
