package org.wahlzeit.model.car;

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
	
	@Test
	public void getterAndSetter() {
		CarPhoto carPhoto = new CarPhoto();
		carPhoto.setCarMake(CarMake.AUDI);
		carPhoto.setMaximumSpeed(20);
		assertNotNull(carPhoto);
		assertEquals(20, carPhoto.getMaximumSpeed(), 0);
		assertEquals(carPhoto.getCarMake(), CarMake.AUDI);
	}
}
