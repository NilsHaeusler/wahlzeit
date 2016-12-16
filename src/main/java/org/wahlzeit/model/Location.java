package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Ignore;

/**
 * A Location represents a location on earth.
 *
 */
public class Location {
	
	/**
	 * represents the Coordinate of this location
	 */
	@Ignore
	private Coordinate coordinate;
	
	/**
	 * creates a new Location for the given Latitude and Longitude
	 * @param latitude
	 * @param longitude
	 */
	public Location(double latitude, double longitude){
		coordinate = SphericCoordinate.getOrCreateCoordinate(latitude, longitude);
	}
	
	/**
	 * creates a new Location for the given x, y and z Cartesian Coordinates
	 * @param x
	 * @param y
	 * @param z
	 */
	public Location(double x, double y, double z){
		coordinate = CartesianCoordinate.getOrCreateCoordinate(x, y, z);
	}
	
	/**
	 * creates a new Location for the given Coordinate
	 * @param coordinate
	 */
	public Location(Coordinate coordinate){
		this.coordinate = coordinate;
	}
	
	/**
	 * gets the distance between this Location and an other Location
	 * @param otherCoordinate the coordinates of an other Location
	 * @return the kilometer on earths surface between this coordinate and otherCoordinate
	 */
	public double getDistance(Location otherLocation) {
		return coordinate.getDistance(otherLocation.coordinate);
	}
}
