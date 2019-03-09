package io.almansa.microservices.limits.limitsservice.bean;

public class LimitConfiguration {
	private int max;
	private int min;

	protected LimitConfiguration() {
	}
	
	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public LimitConfiguration(int max, int min) {
		super();
		this.max = max;
		this.min = min;
	}

}
