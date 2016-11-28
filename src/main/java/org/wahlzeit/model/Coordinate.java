package org.wahlzeit.model;

public interface Coordinate {
	public double getDistance(Coordinate other);
	public boolean isEqual(Coordinate other);
}
