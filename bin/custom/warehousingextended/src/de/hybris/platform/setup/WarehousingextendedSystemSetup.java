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
package de.hybris.platform.setup;

import static de.hybris.platform.constants.WarehousingextendedConstants.PLATFORM_LOGO_CODE;

import de.hybris.platform.core.initialization.SystemSetup;

import java.io.InputStream;

import de.hybris.platform.constants.WarehousingextendedConstants;
import de.hybris.platform.service.WarehousingextendedService;


@SystemSetup(extension = WarehousingextendedConstants.EXTENSIONNAME)
public class WarehousingextendedSystemSetup
{
	private final WarehousingextendedService warehousingextendedService;

	public WarehousingextendedSystemSetup(final WarehousingextendedService warehousingextendedService)
	{
		this.warehousingextendedService = warehousingextendedService;
	}

	@SystemSetup(process = SystemSetup.Process.INIT, type = SystemSetup.Type.ESSENTIAL)
	public void createEssentialData()
	{
		warehousingextendedService.createLogo(PLATFORM_LOGO_CODE);
	}

	private InputStream getImageStream()
	{
		return WarehousingextendedSystemSetup.class.getResourceAsStream("/warehousingextended/sap-hybris-platform.png");
	}
}
