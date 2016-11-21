package org.wahlzeit.model;

public class CartesianCoordinate implements Coordinate{
	protected final double x, y, z;
	
	public CartesianCoordinate(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public CartesianCoordinate(SphericCoordinate other) {
		double latitude = Math.toRadians(other.latitude);
		double longitude = Math.toRadians(other.longitude);
		double radius = other.radius;
		this.x = radius*Math.sin(longitude)*Math.cos(latitude);
		this.y = radius*Math.sin(latitude)*Math.sin(longitude);
		this.z = radius*Math.cos(longitude);
	}

	@Override
	public double getDistance(Coordinate other) throws IllegalArgumentException {
		CartesianCoordinate otherCartesian;
		if(other instanceof CartesianCoordinate){
			otherCartesian = (CartesianCoordinate) other;
		}else if(other instanceof SphericCoordinate){
			otherCartesian = new CartesianCoordinate((SphericCoordinate) other);
		}else{
			throw new IllegalArgumentException("Coordinates not comparable");
		}
		double difX = Math.abs(x-otherCartesian.x);
		double difY = Math.abs(y-otherCartesian.y);
		double difZ = Math.abs(z-otherCartesian.z);
		return Math.sqrt(difX*difX+difY*difY+difZ*difZ);
	}

}
