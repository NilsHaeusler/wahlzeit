package org.wahlzeit.model;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.wahlzeit.model.persistence.ModelPersistenceSuite;

@RunWith(Suite.class)
@SuiteClasses({ AccessRightsTest.class, FlagReasonTest.class, GenderTest.class, GuestTest.class, LocationTest.class,
		PhotoFilterTest.class, TagsTest.class, UserStatusTest.class, ValueTest.class, ModelPersistenceSuite.class })

public class ModelSuite {

}
