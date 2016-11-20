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
	public void testGetDistanceLatitude() {
		SphericCoordinate coordinateA = new SphericCoordinate(90, 0);
		SphericCoordinate coordinateB = new SphericCoordinate(-90, 0);
		assertEquals(coordinateA.getDistance(coordinateB), 6371*Math.PI, 0.1);

		SphericCoordinate coordinateC = new SphericCoordinate(0, 0);
		assertEquals(coordinateC.getDistance(coordinateA), 6371*Math.PI/2, 0.1);
		assertEquals(coordinateC.getDistance(coordinateB), 6371*Math.PI/2, 0.1);
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
	public void testGetDistanceLongitude() {
		SphericCoordinate coordinateA = new SphericCoordinate(0, 180);
		SphericCoordinate coordinateB = new SphericCoordinate(0, -90);
		SphericCoordinate coordinateC = new SphericCoordinate(0, 0);
		SphericCoordinate coordinateD = new SphericCoordinate(0, 90);
		SphericCoordinate coordinateE = new SphericCoordinate(0, -180);
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
		SphericCoordinate coordinateA = new SphericCoordinate(52.517, 13.40);
		SphericCoordinate coordinateB = new SphericCoordinate(35.70, 139.767);
		assertEquals(coordinateA.getDistance(coordinateB), 8919, 0.1);
	}

	/**
	 * 
	 */
	@Test
	public void testSphericToCartesianAndBackPP() {
		SphericCoordinate start = new SphericCoordinate(12.0, 84.0, 6137.0);
		CartesianCoordinate transform = new CartesianCoordinate(start);
		SphericCoordinate end = new SphericCoordinate(transform);
		assertEquals(start.latitude, end.latitude, 0.1);
		assertEquals(start.longitude, end.longitude, 0.1);
		assertEquals(start.radius, end.radius, 0.1);
	}
	
	/**
	 * 
	 */
	@Test
	public void testSphericToCartesianAndBackPN() {
		SphericCoordinate start = new SphericCoordinate(12.0, -84.0, 6137.0);
		CartesianCoordinate transform = new CartesianCoordinate(start);
		SphericCoordinate end = new SphericCoordinate(transform);
		assertEquals(start.latitude, end.latitude, 0.1);
		assertEquals(start.longitude, end.longitude, 0.1);
		assertEquals(start.radius, end.radius, 0.1);
	}
	
	/**
	 * 
	 */
	@Test
	public void testSphericToCartesianAndBackNP() {
		SphericCoordinate start = new SphericCoordinate(-12.0, 84.0, 6137.0);
		CartesianCoordinate transform = new CartesianCoordinate(start);
		SphericCoordinate end = new SphericCoordinate(transform);
		assertEquals(start.latitude, end.latitude, 0.1);
		assertEquals(start.longitude, end.longitude, 0.1);
		assertEquals(start.radius, end.radius, 0.1);
	}
	
	/**
	 * 
	 */
	@Test
	public void testSphericToCartesianAndBackNN() {
		SphericCoordinate start = new SphericCoordinate(-12.0, -84.0, 6137.0);
		CartesianCoordinate transform = new CartesianCoordinate(start);
		SphericCoordinate end = new SphericCoordinate(transform);
		assertEquals(start.latitude, end.latitude, 0.1);
		assertEquals(start.longitude, end.longitude, 0.1);
		assertEquals(start.radius, end.radius, 0.1);
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
