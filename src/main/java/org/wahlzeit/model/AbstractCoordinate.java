package org.wahlzeit.model;

public abstract class AbstractCoordinate implements Coordinate{
	
	public double getDistance(Coordinate other) throws IllegalArgumentException{
		if(other instanceof AbstractCoordinate){
			double difX = Math.abs(this.getX()-((AbstractCoordinate) other).getX());
			double difY = Math.abs(this.getY()-((AbstractCoordinate) other).getY());
			double difZ = Math.abs(this.getZ()-((AbstractCoordinate) other).getZ());
			return Math.sqrt(difX*difX+difY*difY+difZ*difZ);
		}else{
			throw new IllegalArgumentException("Coordinate not compatible");
		}
	}
	
	/**
	 * Coordinates are considered equal if they represent the same spot
	 * The type however may differ
	 * @param other
	 * @return
	 */
	public boolean isEqual(Coordinate other) {
		if(other instanceof AbstractCoordinate){
			if(this.getX() != ((AbstractCoordinate) other).getX()){
				return false;
			}else if(this.getY() != ((AbstractCoordinate) other).getY()){
				return false;
			}else if(this.getZ() != ((AbstractCoordinate) other).getZ()){
				return false;
			}else{
				return true;
			}
		}else{
			throw new IllegalArgumentException("Coordinate not compatible");
		}
	}

	public abstract double getX();
	public abstract double getY();
	public abstract double getZ();
	
}
