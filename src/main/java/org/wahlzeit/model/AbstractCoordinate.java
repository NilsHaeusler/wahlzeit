package org.wahlzeit.model;

public abstract class AbstractCoordinate implements Coordinate{
	
	/**
	 * calculates the Cartesian distance between this coordinate and an other coordinate
	 * the distance is returned in kilometers 
	 * @param other
	 * @return distance
	 */
	public double getDistance(Coordinate other){
		//invariants
		try{
			assertClassInvariants();
		}catch(Exception e){
			throw e;
		}
		//preconditions
		try{
			assertNotNull(other);
			assertIsInstanceOfAbstractCoordinate(other);
		}catch (IllegalArgumentException e) {
			throw e;
		}
		
		double distance = doCalculateDistance((AbstractCoordinate) other);
		
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
			throw e;
		}
		//return
		return distance;
	}

	private double doCalculateDistance(AbstractCoordinate other) {
		double difX = Math.abs(this.getX()-other.getX());
		double difY = Math.abs(this.getY()-other.getY());
		double difZ = Math.abs(this.getZ()-other.getZ());
		double distance = Math.sqrt(difX*difX+difY*difY+difZ*difZ);
		return distance;
	}

	/**
	 * Coordinates are considered equal if they represent the same spot
	 * The type however may differ
	 * @param other
	 * @return true if they are equal
	 */
	public boolean isEqual(Coordinate other){
		//invariants
		try {
			assertClassInvariants();
		} catch (Exception e) {
			throw e;
		}
		//preconditions
		try{
			assertNotNull(other);
			assertIsInstanceOfAbstractCoordinate(other);
		}catch (IllegalArgumentException e) {
			throw e;
		}
		
		boolean returnValue = doIsEqual((AbstractCoordinate) other);
		
		//invariants
		try {
			assertClassInvariants();
		} catch (Exception e) {
			throw e;
		}
		//return
		return returnValue;
	}

	private boolean doIsEqual(AbstractCoordinate other) {
		boolean returnValue;
		//compare x, y and z values
		if(this.getX() != other.getX()){
			returnValue = false;
		}else if(this.getY() != other.getY()){
			returnValue = false;
		}else if(this.getZ() != other.getZ()){
			returnValue = false;
		}else{
			returnValue = true;
		}
		return returnValue;
	}

	/** @return Cartesian x value */
	public abstract double getX();
	/** @return Cartesian y value */
	public abstract double getY();
	/** @return Cartesian z value */
	public abstract double getZ();
	
	private void assertClassInvariants() throws IllegalStateException{
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
