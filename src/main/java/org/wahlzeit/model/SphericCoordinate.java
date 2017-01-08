package org.wahlzeit.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
	
	private static HashMap<Integer, List<SphericCoordinate>> map = new HashMap<Integer, List<SphericCoordinate>>();
	
	private SphericCoordinate(double latitude, double longitude){
		this(latitude, longitude, EARTH_KM_RADIUS);
	}
	
	private SphericCoordinate(double latitude, double longitude, double radius){
		//assert parameters in valid range
		assertIsValidLongitude(longitude);
		assertIsValidLatitude(latitude);
		assertIsValidRadius(radius);
		
		this.latitude = latitude;
		this.longitude = longitude;
		this.radius = radius;
	}
	
	private void assertIsValidRadius(double radius){
		if(radius < 0){
			throw new IllegalArgumentException("radius has to be positiv");
		}
	}

	private void assertIsValidLongitude(double longitude){
		if(longitude > LONGITUDE_MAX || longitude < LONGITUDE_MIN){
			throw new IllegalArgumentException("longitude has to be between "+LONGITUDE_MIN+" and "+LONGITUDE_MAX);
		}
	}

	private void assertIsValidLatitude(double latitude){
		if(latitude > LATITUDE_MAX || latitude < LATITUDE_MIN){
			throw new IllegalArgumentException("latitude has to be between "+LATITUDE_MIN+" and "+LATITUDE_MAX);
		}
	}
	
	public CartesianCoordinate asCartesianCoordinate(){
		return CartesianCoordinate.getOrCreateCoordinate(getX(), getY(), getZ());
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
	
	public synchronized static SphericCoordinate getOrCreateCoordinate(double latitude, double longitude, double radius){
		Tripel tripel = new Tripel(latitude, longitude, radius);
		if(map.containsKey(tripel.hashCode())){
			SphericCoordinate coordinate = new SphericCoordinate(latitude, longitude, radius);
			List<SphericCoordinate> list = map.get(tripel.hashCode());
			for(SphericCoordinate coord : list){
				if(coord.getX() == coordinate.getX() && coord.getY() == coordinate.getY() && coord.getZ() == coordinate.getZ()){
					return coord;
				}
			}
			list.add(coordinate);
			map.put(tripel.hashCode(), list);
			return coordinate;
		}else{
			SphericCoordinate coordinate = new SphericCoordinate(latitude, longitude, radius);
			List<SphericCoordinate> list = new ArrayList<SphericCoordinate>();
			list.add(coordinate);
			map.put(tripel.hashCode(), list);
			return coordinate;
		}
	}
	
	public synchronized static SphericCoordinate getOrCreateCoordinate(double latitude, double longitude){
		return SphericCoordinate.getOrCreateCoordinate(latitude, longitude, EARTH_KM_RADIUS);
	}
	
	private static class Tripel{
		final double latitude, longitude, radius;
		
		private Tripel(double latitude, double longitude, double radius){
			this.latitude = latitude;
			this.longitude = longitude;
			this.radius = radius;
		}
		
		public boolean equals(Object o){
			if((o == null) || !(o instanceof Tripel)){
				return false;
			}
			
			Tripel tupel = (Tripel) o;
			if(latitude == tupel.latitude){
				return false;
			}else if(longitude == tupel.longitude){
				return false;
			}else if(radius == tupel.radius){
				return false;
			}else{
				return true;
			}
		}
		
		public int hashCode(){
			String string = toString();
			int hashCode = string.hashCode();
			return hashCode;
		}
		
		public String toString(){
			return String.valueOf(latitude) + " " + String.valueOf(longitude) + " " + String.valueOf(radius);
		}
	}
}
