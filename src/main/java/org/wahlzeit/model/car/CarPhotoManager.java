package org.wahlzeit.model.car;

import org.wahlzeit.model.PhotoManager;

public class CarPhotoManager extends PhotoManager{

	public CarPhotoManager() {
		//super();
		synchronized (instance) {
			if(instance == null){
				instance = new CarPhotoManager();
			}
		}
		photoTagCollector = CarPhotoFactory.getInstance().createPhotoTagCollector();
	}

}
