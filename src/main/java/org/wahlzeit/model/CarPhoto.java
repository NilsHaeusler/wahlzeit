package org.wahlzeit.model;

public class CarPhoto extends Photo{
	private CarPhotoManager manager;
	
	public CarPhoto(){
		super();
	}
	
	public CarPhoto(PhotoId myId){
		super(myId);
	}
}
