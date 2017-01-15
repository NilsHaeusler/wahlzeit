package org.wahlzeit.model.car;

import org.wahlzeit.model.Photo;
import org.wahlzeit.model.PhotoId;

import com.googlecode.objectify.annotation.Subclass;

@Subclass
public class CarPhoto extends Photo{
	private Car car;
	
	public CarPhoto(){
		super();
	}
	
	public CarPhoto(PhotoId myId){
		super(myId);
		assertPhotoId(myId);
	}
	
	public CarPhoto(PhotoId myId, Car car){
		super(myId);
		//check parameters
		assertPhotoId(myId);
		assertCar(car);
		
		//set variables
		setCar(car);
	}

	private void assertCar(Car car) {
		//no assertion
	}
	
	private void assertPhotoId(PhotoId myId) {
		if(myId == null){
			throw new IllegalArgumentException("PhotoId is null");
		}
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		assertCar(car);
		this.car = car;
	}
}
