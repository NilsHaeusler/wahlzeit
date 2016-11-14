package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.wahlzeit.testEnvironmentProvider.LocalDatastoreServiceTestConfigProvider;

public class CarPhotoTest {
	
	@ClassRule
	public static RuleChain ruleChain = RuleChain.outerRule(new LocalDatastoreServiceTestConfigProvider());
	
	@Before
	public void setUp(){
		CarPhotoManager.getInstance();
	}
	
	@Test
	public void constructor() {
		CarPhoto carPhoto = new CarPhoto();
		assertNotNull(carPhoto);
	}

}
