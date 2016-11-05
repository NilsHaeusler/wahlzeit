package org.wahlzeit.model.persistence;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ DatastoreAdapterTest.class, GcsAdapterTest.class })

public class ModelPersistenceSuite {

}
