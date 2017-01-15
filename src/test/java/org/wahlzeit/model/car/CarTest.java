package org.wahlzeit.model.car;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class CarTest {
	static CarType superType;
	static CarType subType;
	static Car superCar;
	static Car subCar;

	@BeforeClass
	public static void beforeClass(){
		superCar = CarManager.getInstance().createCar("MindYa R3", 200, "RT3-19273884");
		subCar = CarManager.getInstance().createCar("MindYa R4", 180, "RT3-5234441527");
		superType = CarType.getOrCreateCarType("MindYa R3", 200);
		subType = CarType.getOrCreateCarType("MindYa R4", 180);
		superType.addSubType(subType);
	}
	
	@Test
	public void createCar() {
		assertFalse(superCar == null);
	}
	
	@Test
	public void getterCar() {
		assertEquals(superCar.getMaxSpeed(), 200, 0.1);
		assertEquals(superCar.getFahrgestellnummer(), "RT3-19273884");
		assertEquals(superCar.getModel(), "MindYa R3");
		assertEquals(superCar.getType(), superType);
	}
	
	@Test
	public void isSubType() {
		assertTrue(subType.isSubTypeOf(superType));
	}
}
