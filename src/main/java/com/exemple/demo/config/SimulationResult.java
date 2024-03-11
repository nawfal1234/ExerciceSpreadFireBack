package com.exemple.demo.config;

public class SimulationResult {

	private int bunedCellsCount;
	private int steps;
	
	public SimulationResult(int bunedCellsCount, int steps) {
		super();
		this.bunedCellsCount = bunedCellsCount;
		this.steps = steps;
	}

	public int getBunedCellsCount() {
		return bunedCellsCount;
	}

	public void setBunedCellsCount(int bunedCellsCount) {
		this.bunedCellsCount = bunedCellsCount;
	}

	public int getSteps() {
		return steps;
	}

	public void setSteps(int steps) {
		this.steps = steps;
	}
}
