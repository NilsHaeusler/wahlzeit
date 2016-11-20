package org.wahlzeit.model;

public class CartesianCoordinate implements Coordinate{
	protected double x, y, z;
	
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
	public double getDistance(Coordinate other) {
		CartesianCoordinate otherCartesian;
		if(other.getClass() == CartesianCoordinate.class){
			otherCartesian = (CartesianCoordinate) other;
		}else{
			otherCartesian = new CartesianCoordinate((SphericCoordinate) other);
		}
		double difX = Math.abs(x-otherCartesian.x);
		double difY = Math.abs(y-otherCartesian.y);
		double difZ = Math.abs(z-otherCartesian.z);
		return Math.sqrt(difX*difX+difY*difY+difZ*difZ);
	}

}
