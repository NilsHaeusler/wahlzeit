package org.wahlzeit.model.car;

public class CarManager {
	private static CarManager instance;
	
	public static synchronized CarManager getInstance(){
		if(instance == null){
			instance = new CarManager();
		}
		return instance;
	}
	
	public Car createCar(String model, float maxSpeed, String fahrgestellnummer){
		CarType type = getOrCreateCarType(model, maxSpeed);
		Car car = type.createCar(fahrgestellnummer);
		return car;
	}
	
	public CarType getOrCreateCarType(String model, float maxSpeed){
		return CarType.getOrCreateCarType(model, maxSpeed);
	}
}
