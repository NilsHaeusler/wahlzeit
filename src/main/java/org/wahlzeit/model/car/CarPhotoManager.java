package org.wahlzeit.model.car;

import org.wahlzeit.model.PhotoManager;

public class CarPhotoManager extends PhotoManager{

	public CarPhotoManager() {
		super();
		instance = new CarPhotoManager();
		photoTagCollector = CarPhotoFactory.getInstance().createPhotoTagCollector();
	}

}
