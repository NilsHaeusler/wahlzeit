package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.wahlzeit.testEnvironmentProvider.LocalDatastoreServiceTestConfigProvider;

public class CarPhotoManagerTest {

	@ClassRule
	public static RuleChain ruleChain = RuleChain.outerRule(new LocalDatastoreServiceTestConfigProvider());
	
	@Test
	public void constructor() {
		CarPhotoManager manager = new CarPhotoManager();
		assertNotNull(manager);
	}

}
