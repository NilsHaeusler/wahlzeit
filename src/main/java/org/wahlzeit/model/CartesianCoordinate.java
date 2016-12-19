package org.wahlzeit.model;

import java.util.HashMap;

public class CartesianCoordinate extends AbstractCoordinate{
	protected final double x, y, z;
	private static HashMap<Integer, CartesianCoordinate> map = new HashMap<Integer, CartesianCoordinate>();
	
	private CartesianCoordinate(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public double getX() {
		return x;
	}

	@Override
	public double getY() {
		return y;
	}

	@Override
	public double getZ() {
		return z;
	}
	
	public synchronized static CartesianCoordinate getOrCreateCoordinate(double x, double y, double z){
		Tripel tripel = new Tripel(x, y, z);
		if(map.containsKey(tripel.hashCode())){
			return map.get(tripel.hashCode());
		}else{
			CartesianCoordinate coordinate = new CartesianCoordinate(x, y, z);
			map.put(tripel.hashCode(), coordinate);
			return coordinate;
		}
	}
	
	private static class Tripel{
		final double x, y, z;
		
		private Tripel(double x, double y, double z){
			this.x = x;
			this.y = y;
			this.z = z;
		}
		
		public boolean equals(Object o){
			if((o == null) || !(o instanceof Tripel)){
				return false;
			}
			
			Tripel tupel = (Tripel) o;
			if(x == tupel.x){
				return false;
			}else if(y == tupel.y){
				return false;
			}else if(z == tupel.z){
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
			return String.valueOf(x) + " " + String.valueOf(y) + " " + String.valueOf(z);
		}
	}
}
