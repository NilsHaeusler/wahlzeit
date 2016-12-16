package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class CoordinateTest {

	/**
	 * 
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testSphericIllegalArgument() {
		SphericCoordinate.getOrCreateCoordinate(91, -20);
	}
	
	/**
	 * 
	 */
	@Test
	public void testGetDistanceZero() {
		Coordinate coordinate = SphericCoordinate.getOrCreateCoordinate(20, 30);
		assertEquals(coordinate.getDistance(coordinate), 0, 0.1);
	}
	
	/**
	 * 
	 */
	@Test
	public void testGetDistanceSwap() {
		SphericCoordinate coordinateA = SphericCoordinate.getOrCreateCoordinate(70, 50);
		SphericCoordinate coordinateB = SphericCoordinate.getOrCreateCoordinate(20, -10);
		assertEquals(coordinateA.getDistance(coordinateB), coordinateB.getDistance(coordinateA), 0.1);
	}

	/**
	 * 
	 */
	@Test
	public void testSphericToCartesian() {
		SphericCoordinate start = SphericCoordinate.getOrCreateCoordinate(12.0, 84.0, 6137.0);
		CartesianCoordinate end = start.asCartesianCoordinate();
		assertEquals(start.getX(), end.getX(), 0.1);
		assertEquals(start.getY(), end.getY(), 0.1);
		assertEquals(start.getZ(), end.getZ(), 0.1);
		assertTrue(start.equals(end));
		assertTrue(start.isEqual(end));
	}
	
	/**
	 * 
	 */
	@Test
	public void testEquals() {
		SphericCoordinate coordinate = SphericCoordinate.getOrCreateCoordinate(12.0, 84.0, 6137.0);
		SphericCoordinate different = SphericCoordinate.getOrCreateCoordinate(10.0, 80.0, 6137.0);
		assertTrue(coordinate.equals(coordinate));
		assertFalse(coordinate.equals(different));
	}

	/**
	 * 
	 */
	@Test
	public void testGetOrCreate() {
		SphericCoordinate coordinate = SphericCoordinate.getOrCreateCoordinate(12.0, 84.0, 6137.0);
		SphericCoordinate same = SphericCoordinate.getOrCreateCoordinate(12.0, 84.0, 6137.0);
		assertTrue(coordinate.equals(same));
		assertTrue(coordinate == same);
	}
	
	/**
	 * 
	 */
	@Test
	public void testInstanceOf() {
		SphericCoordinate coordinate = SphericCoordinate.getOrCreateCoordinate(12.0, 84.0, 6137.0);
		CartesianCoordinate cartesian = CartesianCoordinate.getOrCreateCoordinate(20.0, 10.0, 40.0);
		assertTrue(coordinate instanceof AbstractCoordinate);
		assertTrue(cartesian instanceof AbstractCoordinate);
	}
	
	/**
	 * 
	 */
	@Test
	public void CartesianDistance() {
		CartesianCoordinate origin = CartesianCoordinate.getOrCreateCoordinate(0.0, 0.0, 0.0);
		CartesianCoordinate other = CartesianCoordinate.getOrCreateCoordinate(2.0, 2.0, 2.0);
		assertEquals(origin.getDistance(other), Math.sqrt(12), 0.1);
	}
}
