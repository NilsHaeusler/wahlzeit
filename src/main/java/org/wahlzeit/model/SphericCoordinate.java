package org.wahlzeit.model;

/**
 * A Coordinate represents polar coordinates of one location on earth
 *
 */
public class SphericCoordinate extends AbstractCoordinate {
	private static final double LONGITUDE_MIN = -180;
	private static final double LONGITUDE_MAX = +180;
	private static final double LATITUDE_MIN = -90;
	private static final double LATITUDE_MAX = +90;
	
	/** radius of earth (assuming it would be a sphere) in kilometer*/
	private final static double EARTH_KM_RADIUS = 6371.0;
	
	//variables for the latitude and longitude on earths surface
	/**
	 * Latitude on earth as double value
	 * positive means North; negative means South (31°45'N would be 31.75)
	 * range should be -90 to +90
	 */
	protected final double latitude;
	/**
	 * Longitude on earth as double value
	 * positive means East; negative means West (31°45'E would be 31.75)
	 * range should be -180 to +180
	 */
	protected final double longitude;
	/** should be Earth Radius for any point on surface */
	protected final double radius;
	
	public SphericCoordinate(double latitude, double longitude) throws IllegalArgumentException{
		this(latitude, longitude, EARTH_KM_RADIUS);
	}
	
	public SphericCoordinate(double latitude, double longitude, double radius) throws IllegalArgumentException{
		//assert parameters in valid range
		assertLongitude(longitude);
		assertLatitude(latitude);
		assertRadius(radius);
		
		this.latitude = latitude;
		this.longitude = longitude;
		this.radius = radius;
	}
	
	private void assertRadius(double radius) throws IllegalArgumentException{
		if(radius < 0){
			throw new IllegalArgumentException("radius has to be positiv");
		}
	}

	private void assertLongitude(double longitude) throws IllegalArgumentException{
		if(longitude > LONGITUDE_MAX || longitude < LONGITUDE_MIN){
			throw new IllegalArgumentException("longitude has to be between "+LONGITUDE_MIN+" and "+LONGITUDE_MAX);
		}
	}

	private void assertLatitude(double latitude) throws IllegalArgumentException{
		if(latitude > LATITUDE_MAX || latitude < LATITUDE_MIN){
			throw new IllegalArgumentException("latitude has to be between "+LATITUDE_MIN+" and "+LATITUDE_MAX);
		}
	}
	
	public CartesianCoordinate asCartesianCoordinate(){
		return new CartesianCoordinate(getX(), getY(), getZ());
	}

	@Override
	public double getX() {
		double x = radius*Math.sin(Math.toRadians(longitude))*Math.cos(Math.toRadians(latitude));
		return x;
	}

	@Override
	public double getY() {
		double y = radius*Math.sin(Math.toRadians(latitude))*Math.sin(Math.toRadians(longitude));
		return y;
	}

	@Override
	public double getZ() {
		double z = radius*Math.cos(Math.toRadians(longitude));
		return z;
	}
}
