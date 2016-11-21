package org.wahlzeit.model;

/**
 * A Coordinate represents polar coordinates of one location on earth
 *
 */
public class SphericCoordinate implements Coordinate {
	private static final double LONGITUDE_MIN = -180;
	private static final double LONGITUDE_MAX = +180;
	private static final double LATITUDE_MIN = -90;
	private static final double LATITUDE_MAX = +90;
	
	/** radius of earth (assuming it would be a sphere) in kilometer
	 */
	private final static double EARTH_KM_RADIUS = 6371.0;
	
	//variables for the latitude and longitude on earths surface
	/**
	 * Latitude on earth as double value
	 * positive means North; negative means South (31°45'N would be 31.75)
	 * range should be -90 to +90
	 */
	protected double latitude;
	/**
	 * Longitude on earth as double value
	 * positive means East; negative means West (31°45'E would be 31.75)
	 * range should be -180 to +180
	 */
	protected double longitude;
	/**
	 * should be Earth Radius for any point on surface
	 */
	protected double radius;
	
	public SphericCoordinate(double latitude, double longitude) throws IllegalArgumentException{
		this(latitude, longitude, EARTH_KM_RADIUS);
	}
	
	public SphericCoordinate(double latitude, double longitude, double radius) throws IllegalArgumentException{
		if(longitude > LONGITUDE_MAX || longitude < LONGITUDE_MIN){
			throw new IllegalArgumentException("longitude has to be between "+LONGITUDE_MIN+" and "+LONGITUDE_MAX);
		}
		if(latitude > LATITUDE_MAX || latitude < LATITUDE_MIN){
			throw new IllegalArgumentException("latitude has to be between "+LATITUDE_MIN+" and "+LATITUDE_MAX);
		}
		if(radius < 0){
			throw new IllegalArgumentException("radius has to be positiv");
		}
		this.latitude = latitude;
		this.longitude = longitude;
		this.radius = radius;
	}
	
	public SphericCoordinate(CartesianCoordinate other) {
		double x = other.x;
		double y = other.y;
		double z = other.z;
		
		//convert to spheric
		double radius = Math.sqrt(x*x+y*y+z*z);
		double longitude = Math.signum(x)*Math.toDegrees(Math.atan(Math.sqrt(x*x+y*y)/z));
		double latitude = Math.toDegrees(Math.atan(y/x));
		//check for invalid arguments
		if(longitude > LONGITUDE_MAX || longitude < LONGITUDE_MIN){
			throw new IllegalArgumentException("longitude has to be between "+LONGITUDE_MIN+" and "+LONGITUDE_MAX);
		}
		if(latitude > LATITUDE_MAX || latitude < LATITUDE_MIN){
			throw new IllegalArgumentException("latitude has to be between "+LATITUDE_MIN+" and "+LATITUDE_MAX);
		}
		if(radius < 0){
			throw new IllegalArgumentException("radius has to be positiv");
		}
		//set variables
		this.latitude = latitude;
		this.longitude = longitude;
		this.radius = radius;
	}

	/**
	 * gets the distance between this Coordinate and an other Coordinate
	 * @param other the coordinates of an other Location
	 * @return the kilometer on earths surface between this coordinate and otherCoordinate
	 */
	@Override
	public double getDistance(Coordinate other) {
		SphericCoordinate otherSpheric;
		if(other instanceof SphericCoordinate){
			otherSpheric = (SphericCoordinate) other;
		}else{
			otherSpheric = new SphericCoordinate((CartesianCoordinate) other);
		}
		//casting values to radians for sinus and cosinus
		double difLongitude = (otherSpheric.longitude-longitude);
		double difLongitudeToRadians = Math.toRadians(difLongitude);
		double latitudeToRadians = Math.toRadians(latitude);
		double otherLatitudeToRadians = Math.toRadians(otherSpheric.latitude);
		//angle between the two Coordinates
		double sigma = Math.acos(Math.sin(latitudeToRadians)*Math.sin(otherLatitudeToRadians)+Math.cos(latitudeToRadians)*Math.cos(otherLatitudeToRadians)*Math.cos(difLongitudeToRadians));
		return sigma*radius;
	}
}
