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
		Car car = CarManager.getInstance().createCar("FanCar D7", 120, "FIN01022121223");
		CarPhoto carPhoto = new CarPhoto();
		carPhoto.setCar(car);
		assertNotNull(carPhoto);
		assertNotNull(carPhoto.getCar());
	}
}
