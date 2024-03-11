package com.exemple.demo.config;


import java.util.List;

import com.example.demo.model.Cell;


public class Configuration {
	private int height;
	private int width;
	private double pP;
	private List<Cell> initialFireCells;
	
	
	public Configuration(int height, int width, double pP, List<Cell> initialFireCells) {
		super();
		this.height = height;
		this.width = width;
		this.pP = pP;
		this.initialFireCells = initialFireCells;
	}


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}


	public int getWidth() {
		return width;
	}


	public void setWidth(int width) {
		this.width = width;
	}


	public double getpP() {
		return pP;
	}


	public void setpP(double pP) {
		this.pP = pP;
	}


	public List<Cell> getInitialFireCells() {
		return initialFireCells;
	}


	public void setInitialFireCells(List<Cell> initialFireCells) {
		this.initialFireCells = initialFireCells;
	}
	
	
}
