package org.wahlzeit.model.car;

import org.wahlzeit.model.PhotoManager;

public class CarPhotoManager extends PhotoManager{
	protected static final CarPhotoManager instance = new CarPhotoManager();

	public CarPhotoManager() {
		super();
	}

}
