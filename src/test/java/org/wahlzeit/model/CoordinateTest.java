package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class CoordinateTest {

	/**
	 * 
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testPhericIllegalArgument() {
		new SphericCoordinate(91, -20);
	}
	
	/**
	 * 
	 */
	@Test
	public void testGetDistanceZero() {
		Coordinate coordinate = new SphericCoordinate(20, 30);
		assertEquals(coordinate.getDistance(coordinate), 0, 0.1);
	}
	
	/**
	 * 
	 */
	@Test
	public void testGetDistanceSwap() {
		SphericCoordinate coordinateA = new SphericCoordinate(70, 50);
		SphericCoordinate coordinateB = new SphericCoordinate(20, -10);
		assertEquals(coordinateA.getDistance(coordinateB), coordinateB.getDistance(coordinateA), 0.1);
	}

	/**
	 * 
	 */
	@Test
	public void testSphericToCartesian() {
		SphericCoordinate start = new SphericCoordinate(12.0, 84.0, 6137.0);
		CartesianCoordinate end = start.asCartesianCoordinate();
		assertEquals(start.getX(), end.getX(), 0.1);
		assertEquals(start.getY(), end.getY(), 0.1);
		assertEquals(start.getZ(), end.getZ(), 0.1);
		assertTrue(start.isEqual(end));
	}
	
	/**
	 * 
	 */
	@Test
	public void CartesianDistance() {
		CartesianCoordinate origin = new CartesianCoordinate(0.0, 0.0, 0.0);
		CartesianCoordinate other = new CartesianCoordinate(2.0, 2.0, 2.0);
		assertEquals(origin.getDistance(other), Math.sqrt(12), 0.1);
	}
}
