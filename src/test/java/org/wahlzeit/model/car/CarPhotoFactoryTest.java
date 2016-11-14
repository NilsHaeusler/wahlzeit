package org.wahlzeit.model.car;

import static org.junit.Assert.assertNotNull;

import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.wahlzeit.testEnvironmentProvider.LocalDatastoreServiceTestConfigProvider;

public class CarPhotoFactoryTest {
 
	@ClassRule
	public static RuleChain ruleChain = RuleChain.outerRule(new LocalDatastoreServiceTestConfigProvider());
	
	@Test
	public void constructor() {
		CarPhotoFactory factory = new CarPhotoFactory();
		assertNotNull(factory);
	}
}
