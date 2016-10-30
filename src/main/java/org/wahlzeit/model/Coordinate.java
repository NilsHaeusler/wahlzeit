package org.wahlzeit.model;

/**
 * A Coordinate represents polar coordinates of one location on earth
 *
 */
public class Coordinate {
	/** radius of earth (assuming it would be a sphere)
	 */
	private final int EARTH_RADIUS = 6371;
	
	//variables for the latitude and longitude on earths surface
	/**
	 * Latitude on earth as double value
	 * positive means North; negative means South (31°45'N would be 31.75)
	 * range should be -90 to +90
	 */
	private double latitude;
	/**
	 * Longitude on earth as double value
	 * positive means East; negative means West (31°45'E would be 31.75)
	 * range should be -180 to +180
	 */
	private double longitude;
	
	public Coordinate(double latitude, double longitude){
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	/**
	 * gets the distance between this Coordinate and an other Coordinate
	 * @param otherCoordinate the coordinates of an other Location
	 * @return the kilometer on earths surface between this coordinate and otherCoordinate
	 */
	public double getDistance(Coordinate otherCoordinate) {
		double difLongitude = (otherCoordinate.longitude-longitude)%360;
		double difLongitudeToRadians = Math.toRadians(difLongitude);
		double latitudeToRadians = Math.toRadians(latitude);
		double otherLatitudeToRadians = Math.toRadians(otherCoordinate.latitude);
		//angle between the two Coordinates
		double sigma = Math.acos(Math.sin(latitudeToRadians)*Math.sin(otherLatitudeToRadians)+Math.cos(latitudeToRadians)*Math.cos(otherLatitudeToRadians)*Math.cos(difLongitudeToRadians));
		return sigma*EARTH_RADIUS;
	}
}
