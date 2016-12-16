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
		assertClassInvariants();
		//preconditions
		assertNotNull(other);
		assertIsInstanceOfAbstractCoordinate(other);
		
		double distance = doCalculateDistance((AbstractCoordinate) other);
		
		//postConditions
		assertDistanceIsNotNegative(distance);
		//invariants
		assertClassInvariants();
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
		assertClassInvariants();
		//preconditions
		assertNotNull(other);
		assertIsInstanceOfAbstractCoordinate(other);
		
		boolean returnValue = doIsEqual((AbstractCoordinate) other);
		
		//invariants
		assertClassInvariants();
		
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
	
	private void assertClassInvariants(){
		//no class Invariants yet
	}

	private void assertNotNull(Coordinate other){
		if(other == null){
			throw new IllegalArgumentException("Coordinate must not be null");
		}
	}
	
	private void assertIsInstanceOfAbstractCoordinate(Coordinate other){
		if(!(other instanceof AbstractCoordinate)){
			throw new IllegalArgumentException("Coordinate not compatible");
		}
	}
	
	private void assertDistanceIsNotNegative(double distance){
		if(distance < 0){
			throw new RuntimeException("distance has to be not negative");
		}
	}
	
	@Override
	/**
	 * returns true if o is an AbstractCoordinate representing the same location
	 * does not have to be of the same type
	 */
	public boolean equals(Object o){
		if((o == null) || !(o instanceof AbstractCoordinate)){
			return false;
		}
		
		AbstractCoordinate coordinate = (AbstractCoordinate) o;
		if(this.getX() != coordinate.getX()){
			return false;
		}else if(this.getY() != coordinate.getY()){
			return false;
		}else if(this.getZ() != coordinate.getZ()){
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
		return String.valueOf(getX()) + " " + String.valueOf(getY()) + " " + String.valueOf(getZ());
	}
}
