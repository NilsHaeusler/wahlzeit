package org.wahlzeit.model;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.wahlzeit.model.car.CarPhotoFactoryTest;
import org.wahlzeit.model.car.CarPhotoManagerTest;
import org.wahlzeit.model.car.CarPhotoTest;
import org.wahlzeit.model.car.ModelCarSuite;
import org.wahlzeit.model.persistence.ModelPersistenceSuite;

@RunWith(Suite.class)
@SuiteClasses({ AccessRightsTest.class, FlagReasonTest.class, GenderTest.class, GuestTest.class, LocationTest.class,
		PhotoFilterTest.class, TagsTest.class, UserStatusTest.class, ValueTest.class, ModelPersistenceSuite.class, 
		ModelCarSuite.class, CoordinateTest.class })

public class ModelSuite {

}
