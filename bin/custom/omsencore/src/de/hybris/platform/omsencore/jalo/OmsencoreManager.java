/*
 * [y] hybris Platform
 *
 * Copyright (c) 2017 SAP SE or an SAP affiliate company.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 *
 */
package de.hybris.platform.omsencore.jalo;

import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.jalo.extension.ExtensionManager;
import de.hybris.platform.omsencore.constants.OmsencoreConstants;
import org.apache.log4j.Logger;

@SuppressWarnings("PMD")
public class OmsencoreManager extends GeneratedOmsencoreManager
{
	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger( OmsencoreManager.class.getName() );
	
	public static final OmsencoreManager getInstance()
	{
		ExtensionManager em = JaloSession.getCurrentSession().getExtensionManager();
		return (OmsencoreManager) em.getExtension(OmsencoreConstants.EXTENSIONNAME);
	}
	
}
