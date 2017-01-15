package org.wahlzeit.model.car;

public class Car {
	private CarType type;
	private String fahrgestellnummer;
	
	public String getFahrgestellnummer() {
		return fahrgestellnummer;
	}

	public void setFahrgestellnummer(String fahrgestellnummer) {
		this.fahrgestellnummer = fahrgestellnummer;
	}

	public Car(String fahrgestellnummer) {
		this.fahrgestellnummer = fahrgestellnummer;
	}

	public CarType getType() {
		return type;
	}

	public void setType(CarType type) {
		this.type = type;
	}

	public float getMaxSpeed() {
		return type.getMaxSpeed();
	}
	
	public String getModel(){
		return type.getModel();
	}
}
