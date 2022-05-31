package com.camcar;

public class LimitConfiguration {
	
	private int minimum;
	private int maximum;
	
	protected LimitConfiguration() {
		
	}

	public LimitConfiguration(int maximum, int minimum) {
		super();
		this.maximum = maximum;
		this.minimum = minimum;
	}

	public int getMaximum() {
		return maximum;
	}

	public int getMinimum() {
		return minimum;
	}

}
