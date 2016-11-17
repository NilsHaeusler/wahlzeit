package org.wahlzeit.model.car;

import org.wahlzeit.model.Photo;
import org.wahlzeit.model.PhotoFactory;
import org.wahlzeit.model.PhotoId;
import org.wahlzeit.services.LogBuilder;

public class CarPhotoFactory extends PhotoFactory {

	protected CarPhotoFactory() {
		super();
		//TODO check if correctInstance is set
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
		return new CarPhoto(id);
	}
}
