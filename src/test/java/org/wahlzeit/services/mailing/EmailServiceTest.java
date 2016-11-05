/*
 * Copyright (c) 2006-2009 by Dirk Riehle, http://dirkriehle.com
 *
 * This file is part of the Wahlzeit photo rating application.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */
package org.wahlzeit.services.mailing;

import junit.framework.TestCase;

import org.junit.Before;
import org.wahlzeit.services.EmailAddress;

/**
 * JUnit-Test class for EmailService 
 */
public class EmailServiceTest extends TestCase {

	/**
	 * mocked emailService
	 */
	protected EmailService emailService = null;

	/**
	 * test-mailaddress
	 */
	protected EmailAddress validAddress;


	/**
	 *
	 */
	@Before
	protected void setUp() throws Exception {
		super.setUp();
		
		//override the EmailServiceManagers default Service to the MockService
		EmailServiceManager.getInstance().defaultService = new LoggingEmailService(new MockEmailService());
		
		emailService = EmailServiceManager.getDefaultService();

		validAddress = EmailAddress.getFromString("test@test.de");
	}
	
	/**
	 * 
	 */
	@Override
	protected void tearDown() throws Exception {
		//nothing to tear down
	}

	/**
	 *
	 */
	public void testSendInvalidEmail() {
		try {
			assertFalse(emailService.sendEmailIgnoreException(validAddress, null, "lol", "hi"));
			assertFalse(emailService.sendEmailIgnoreException(null, validAddress, null, "body"));
			assertFalse(emailService.sendEmailIgnoreException(validAddress, null, "hi", "       "));
		} catch (Exception ex) {
			fail("Silent mode does not allow exceptions");
		}
	}

	/**
	 *
	 */
	public void testSendValidEmail() {
		try {
			assertTrue(emailService.sendEmailIgnoreException(validAddress, validAddress, "hi", "test"));
		} catch (Exception ex) {
			fail("Silent mode does not allow exceptions");
		}
	}
}
