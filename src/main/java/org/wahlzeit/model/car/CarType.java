package org.wahlzeit.model.car;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CarType {
	private static Map<String, CarType> typesMap = new HashMap<String, CarType>();
	//attributes
	private String model;
	private float maxSpeed;
	public Set<CarType> subTypes = new HashSet<CarType>();
	
	private CarType(String model, float maxSpeed){
		this.setModel(model);
		this.setMaxSpeed(maxSpeed);
	}

	public synchronized static CarType getOrCreateCarType(String model, float maxSpeed) {
		if(!typesMap.containsKey(model)){
			CarType carType = new CarType(model, maxSpeed);
			typesMap.put(model, carType);
		}
		return typesMap.get(model);
	}

	public Car createCar(String fahrgestellnummer) {
		Car car = new Car(fahrgestellnummer);
		car.setType(this);
		return car;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public float getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(float maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	
	public void addSubType(CarType carType){
		subTypes.add(carType);
	}
	
	public void removeSubType(CarType carType){
		subTypes.remove(carType);
	}
	
	/**
	 * 
	 * @param carType
	 * @return true if this CarType is a subType of carType
	 */
	public boolean isSubTypeOf(CarType carType){
		return carType.getSubTypes().contains(this);
	}

	private Set<CarType> getSubTypes() {
		return subTypes;
	}
}
