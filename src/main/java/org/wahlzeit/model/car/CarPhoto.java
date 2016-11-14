package org.wahlzeit.model.car;

import org.wahlzeit.model.Photo;
import org.wahlzeit.model.PhotoId;

import com.googlecode.objectify.annotation.Subclass;

@Subclass
public class CarPhoto extends Photo{
	private CarMake carMake = CarMake.UNKNOWN;
	private float maximumSpeed = 0;
	
	public CarPhoto(){
		super();
	}
	
	public CarPhoto(PhotoId myId){
		super(myId);
	}
	
	public CarPhoto(PhotoId myId, CarMake carMake, float maximumSpeed){
		super(myId);
		setCarMake(carMake);
		setMaximumSpeed(maximumSpeed);
	}

	public CarMake getCarMake() {
		return carMake;
	}

	public void setCarMake(CarMake carMake) {
		this.carMake = carMake;
	}

	public float getMaximumSpeed() {
		return maximumSpeed;
	}

	public void setMaximumSpeed(float maximumSpeed) {
		this.maximumSpeed = maximumSpeed;
	}
}
