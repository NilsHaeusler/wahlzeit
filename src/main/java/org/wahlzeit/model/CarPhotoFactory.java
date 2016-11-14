package org.wahlzeit.model;

import java.util.logging.Logger;

import org.wahlzeit.services.LogBuilder;

public class CarPhotoFactory extends PhotoFactory{
	private static final Logger log = Logger.getLogger(PhotoFactory.class.getName());
	/**
	 * Hidden singleton instance; needs to be initialized from the outside.
	 */
	private static CarPhotoFactory instance = null;
	
	protected CarPhotoFactory(){
		//do nothing
	}
	
	public static void initalize(){
		getInstance(); //only instantiate
	}
	
	public static synchronized PhotoFactory getInstance() {
		if (instance == null) {
			log.config(LogBuilder.createSystemMessage().addAction("setting generic CarPhotoFactory").toString());
			setInstance(new CarPhotoFactory());
		}

		return instance;
	}
	
	public static synchronized void setInstance(CarPhotoFactory carPhotoFactory){
		if (instance != null) {
			throw new IllegalStateException("attempt to initalize CarPhotoFactory twice");
		}

		instance = carPhotoFactory;
	}
	
	public CarPhoto createCarPhoto(PhotoId id){
		return new CarPhoto(id);
	}
}
