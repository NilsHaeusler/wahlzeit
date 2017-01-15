package org.wahlzeit.model.car;

import org.wahlzeit.model.Photo;
import org.wahlzeit.model.PhotoFactory;
import org.wahlzeit.model.PhotoId;
import org.wahlzeit.services.LogBuilder;

public class CarPhotoFactory extends PhotoFactory {

	protected CarPhotoFactory() {
		super();
	}

	public static synchronized PhotoFactory getInstance() {
		if (instance == null) {
			log.config(LogBuilder.createSystemMessage().addAction("setting generic CarPhotoFactory").toString());
			setInstance(new CarPhotoFactory());
		}

		return instance;
	}

	@Override
	public Photo createPhoto(PhotoId id) {
		assertPhotoId(id);
		CarPhoto carPhoto = new CarPhoto(id);
		return carPhoto;
	}
	
	public Photo createPhoto(PhotoId id, Car car) {
		assertPhotoId(id);
		CarPhoto carPhoto = new CarPhoto(id);
		carPhoto.setCar(car);
		return carPhoto;
	}

	private void assertPhotoId(PhotoId id) {
		if(id == null){
			throw new IllegalArgumentException("PhotoId must not be null");
		}
	}
}
