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
		assertPhotoId(myId);
	}
	
	public CarPhoto(PhotoId myId, CarMake carMake, float maximumSpeed){
		super(myId);
		//check parameters
		assertPhotoId(myId);
		assertCarMake(carMake);
		assertMaximumSpeed(maximumSpeed);
		
		//set variables
		setCarMake(carMake);
		setMaximumSpeed(maximumSpeed);
	}

	private void assertMaximumSpeed(float maximumSpeed) {
		if(maximumSpeed < 0){
			throw new IllegalArgumentException("maximumSpeed has to be positive");
		}
	}

	private void assertCarMake(CarMake carMake) {
		if(carMake == null){
			throw new IllegalArgumentException("carMake must be set");
		}
	}
	
	private void assertPhotoId(PhotoId myId) {
		if(myId == null){
			throw new IllegalArgumentException("PhotoId is null");
		}
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
