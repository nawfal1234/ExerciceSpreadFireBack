package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Grid {

	private int height;
	private int width;
	private double pP;
	private Cell[][] cells;
	private int steps;
	private int burnedCellsCount;
	private List<Cell> etatFireGrid;
	
	public Grid() {
	}
	
	

	public Grid(int height, int width, double pP, int steps, int burnedCellsCount) {
		super();
		this.height = height;
		this.width = width;
		this.pP = pP;
		this.steps = steps;
		this.burnedCellsCount = burnedCellsCount;
		
	}


	public Grid(int height, int width,double pP, List<Cell> initialFireCells) {
		super();
		this.height = height;
		this.width = width;
		this.pP= pP;
		this.cells = new Cell[height][width];
		initializeCells(initialFireCells);

	}
	public void initializeCells(List<Cell> initialFireCells) {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				cells[i][j] = new Cell(i, j);
			}
		}
		for (Cell fireCell : initialFireCells) {
			cells[fireCell.getCordX()][fireCell.getCordY()].setOnFire(fireCell.getOnFire());
		}
	}

	
	public double getpP() {
		return pP;
	}

	public void setpP(double pP) {
		this.pP = pP;
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

	public Cell[][] getCells() {
		return cells;
	}

	public void setCells(Cell[][] cells) {
		this.cells = cells;
	}
	
	public int getSteps() {
		return steps;
	}

	public void setSteps(int steps) {
		this.steps = steps;
	}

	public int getBurnedCellsCount() {
		return burnedCellsCount;
	}

	public void setBurnedCellsCount(int burnedCellsCount) {
		this.burnedCellsCount = burnedCellsCount;
	}

	public List<Cell> getEtatFireGrid() {
		return etatFireGrid;
	}


	public void setEtatFireGrid(List<Cell> etatFireGrid) {
		this.etatFireGrid = etatFireGrid;
	}
}