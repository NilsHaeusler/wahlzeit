package org.wahlzeit.model;

public abstract class AbstractCoordinate implements Coordinate{
	
	/**
	 * calculates the cartesian distance between this coordinate and an other coordinate
	 * the distance is returned in kilometers 
	 * @param other
	 * @return distance
	 */
	public double getDistance(Coordinate other) throws IllegalArgumentException{
		//invariants
		try{
			assertClassInvariants();
		}catch(Exception e){
			throw new IllegalStateException(e);
		}
		//preconditions
		try{
			assertNotNull(other);
			assertIsInstanceOfAbstractCoordinate(other);
		}catch (IllegalArgumentException e) {
			throw e;
		}
		
		double difX = Math.abs(this.getX()-((AbstractCoordinate) other).getX());
		double difY = Math.abs(this.getY()-((AbstractCoordinate) other).getY());
		double difZ = Math.abs(this.getZ()-((AbstractCoordinate) other).getZ());
		double distance = Math.sqrt(difX*difX+difY*difY+difZ*difZ);
		
		//postConditions
		try{
			assertDistanceIsNotNegative(distance);
		}catch (RuntimeException e) {
			throw e;
		}
		//invariants
		try {
			assertClassInvariants();
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
		//return
		return distance;
	}

	/**
	 * Coordinates are considered equal if they represent the same spot
	 * The type however may differ
	 * @param other
	 * @return true if they are equal
	 */
	public boolean isEqual(Coordinate other) throws IllegalArgumentException{
		//invariants
		try {
			assertClassInvariants();
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
		//preconditions
		try{
			assertNotNull(other);
			assertIsInstanceOfAbstractCoordinate(other);
		}catch (IllegalArgumentException e) {
			throw e;
		}
		
		//compare x, y and z values
		boolean returnValue;
		if(this.getX() != ((AbstractCoordinate) other).getX()){
			returnValue = false;
		}else if(this.getY() != ((AbstractCoordinate) other).getY()){
			returnValue = false;
		}else if(this.getZ() != ((AbstractCoordinate) other).getZ()){
			returnValue = false;
		}else{
			returnValue = true;
		}
		
		//invariants
		try {
			assertClassInvariants();
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
		//return
		return returnValue;
	}

	/** @return Cartesian x value */
	public abstract double getX();
	/** @return Cartesian y value */
	public abstract double getY();
	/** @return Cartesian z value */
	public abstract double getZ();
	
	private void assertClassInvariants() throws Exception{
		//no class Invariants yet
	}

	private void assertNotNull(Coordinate other) throws IllegalArgumentException{
		if(other == null){
			throw new IllegalArgumentException("Coordinate must not be null");
		}
	}
	
	private void assertIsInstanceOfAbstractCoordinate(Coordinate other) throws IllegalArgumentException{
		if(!(other instanceof AbstractCoordinate)){
			throw new IllegalArgumentException("Coordinate not compatible");
		}
	}
	
	private void assertDistanceIsNotNegative(double distance) throws RuntimeException{
		if(distance < 0){
			throw new RuntimeException("distance has to be not negative");
		}
	}
}
