package org.wahlzeit.model;

import static org.junit.Assert.*;
import org.junit.*;

public class LocationTest {
	
	/**
	 * 
	 */
	@Test
	public void testCoordinateDistanceEqualsLocationDistance() {
		Coordinate spheric = SphericCoordinate.getOrCreateCoordinate(30, -20);
		Coordinate cartesian = CartesianCoordinate.getOrCreateCoordinate(200, 50, 200);
		Location locationSpheric = new Location(spheric);
		Location locationCartesian = new Location(cartesian);
		assertEquals(spheric.getDistance(cartesian), locationSpheric.getDistance(locationCartesian), 0.1);
	}
}
