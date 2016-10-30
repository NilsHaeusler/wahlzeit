package org.wahlzeit.model;

import static org.junit.Assert.*;
import org.junit.*;

public class LocationTest {
	
	/**
	 * 
	 */
	@Test
	public void testCoordinateDistanceEqualsLocationDistance() {
		Coordinate coordinateA = new Coordinate(30, -20);
		Coordinate coordinateB = new Coordinate(-40, 50);
		Location locationA = new Location(coordinateA);
		Location locationB = new Location(coordinateB);
		assertEquals(coordinateA.getDistance(coordinateB), locationA.getDistance(locationB), 0.1);
	}
	
	/**
	 * 
	 */
	@Test
	public void testGetDistanceZero() {
		Coordinate coordinateA = new Coordinate(20, 30);
		Location locationA = new Location(coordinateA);
		assertEquals(coordinateA.getDistance(coordinateA), 0, 0.1);
		assertEquals(locationA.getDistance(locationA), 0, 0.1);
	}
	
	/**
	 * 
	 */
	@Test
	public void testGetDistanceLatitude() {
		Coordinate coordinateA = new Coordinate(90, 0);
		Coordinate coordinateB = new Coordinate(-90, 0);
		assertEquals(coordinateA.getDistance(coordinateB), 6371*Math.PI, 0.1);

		Coordinate coordinateC = new Coordinate(0, 0);
		assertEquals(coordinateC.getDistance(coordinateA), 6371*Math.PI/2, 0.1);
		assertEquals(coordinateC.getDistance(coordinateB), 6371*Math.PI/2, 0.1);
	}
	
	/**
	 * 
	 */
	@Test
	public void testGetDistanceSwap() {
		Coordinate coordinateA = new Coordinate(70, 50);
		Coordinate coordinateB = new Coordinate(20, -10);
		assertEquals(coordinateA.getDistance(coordinateB), coordinateB.getDistance(coordinateA), 0.1);
	}
	
	/**
	 * 
	 */
	@Test
	public void testGetDistanceLongitude() {
		Coordinate coordinateA = new Coordinate(0, -180);
		Coordinate coordinateB = new Coordinate(0, -90);
		Coordinate coordinateC = new Coordinate(0, 0);
		Coordinate coordinateD = new Coordinate(0, 90);
		Coordinate coordinateE = new Coordinate(0, 180);
		assertEquals(coordinateA.getDistance(coordinateB), 6371*Math.PI/2, 0.1);
		assertEquals(coordinateA.getDistance(coordinateC), 6371*Math.PI, 0.1);
		assertEquals(coordinateA.getDistance(coordinateD), 6371*Math.PI/2, 0.1);
		assertEquals(coordinateA.getDistance(coordinateE), 0, 0.1);
		assertEquals(coordinateB.getDistance(coordinateC), 6371*Math.PI/2, 0.1);
		assertEquals(coordinateB.getDistance(coordinateD), 6371*Math.PI, 0.1);
		assertEquals(coordinateB.getDistance(coordinateE), 6371*Math.PI/2, 0.1);
		assertEquals(coordinateC.getDistance(coordinateD), 6371*Math.PI/2, 0.1);
		assertEquals(coordinateC.getDistance(coordinateE), 6371*Math.PI, 0.1);
		assertEquals(coordinateD.getDistance(coordinateE), 6371*Math.PI/2, 0.1);
	}
	
	/**
	 * 
	 */
	@Test
	public void testDataFromWeb() {
		Coordinate coordinateA = new Coordinate(52.517, 13.40);
		Coordinate coordinateB = new Coordinate(35.70, 139.767);
		assertEquals(coordinateA.getDistance(coordinateB), 8919, 0.1);
	}
}
