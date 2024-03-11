package com.example.demo.service;

import java.util.*;

import com.example.demo.model.Cell;
import com.example.demo.model.Grid;
import com.exemple.demo.config.Configuration;

public class FireService {
	
	Grid grid;
	
	public FireService(Grid grid) {
		this.grid = grid;
//		Configuration config = ConfigurationReader.loadConfiguration(grid);
	}
	public List<Cell> update(double pP) {
		
		List<Cell> etatFireGrid=new ArrayList();
		
		for (int i = 0; i < grid.getHeight(); i++) {
			Cell currentCell =null;
			for (int j = 0; j< grid.getWidth(); j++) {
			 currentCell = grid.getCells()[i][j];
				if (currentCell.getOnFire()) {
					currentCell.setOnFire(false);
					currentCell.setBurned(true);

					if (i == 0 && j == 0) {
						if (RandomProbability () >= pP && !grid.getCells()[i + 1][j].getBurned()) {
							grid.getCells()[i][j + 1].setOnFire(true);
						}  if (RandomProbability () >= pP && !grid.getCells()[i + 1][j].getBurned()) {
							grid.getCells()[i + 1][j].setOnFire(true);
						}
					} else if (i > 0 && i < grid.getHeight() - 1 && j > 0 && j < grid.getWidth() - 1) {
						if (RandomProbability () >= pP && !grid.getCells()[i - 1][j].getBurned()) {
							grid.getCells()[i - 1][j].setOnFire(true);
						}  if (RandomProbability () >= pP && !grid.getCells()[i + 1][j].getBurned()) {
							grid.getCells()[i + 1][j].setOnFire(true);
						}  if (RandomProbability () >= pP && !grid.getCells()[i][j - 1].getBurned()) {
							grid.getCells()[i][j - 1].setOnFire(true);
						}  if (RandomProbability () >= pP && !grid.getCells()[i][j + 1].getBurned()) {
							grid.getCells()[i][j + 1].setOnFire(true);
						}
					} else if (i == grid.getHeight() - 1 && j == 0) {
						if (RandomProbability () >= pP && !grid.getCells()[i - 1][j].getBurned()) {
							grid.getCells()[i - 1][j].setOnFire(true);
							
						}  if (RandomProbability () >= pP && !grid.getCells()[i][j + 1].getBurned()) {
							grid.getCells()[i][j + 1].setOnFire(true);
							
						}
					} else if (i == grid.getHeight() - 1 && j == grid.getWidth() - 1) {
						if (RandomProbability() >= pP && !grid.getCells()[i][j - 1].getBurned()) {
							grid.getCells()[i][j - 1].setOnFire(true);
							
						}  if (RandomProbability() >= pP && !grid.getCells()[i - 1][j].getBurned()) {
							grid.getCells()[i - 1][j].setOnFire(true);
							
						}
					} else if (i == 0 && j == grid.getWidth() - 1) {
						if (RandomProbability() >= pP && !grid.getCells()[i][j - 1].getBurned ()) {
							grid.getCells()[i][j - 1].setOnFire(true);
							
						}  if (RandomProbability() >= pP && !grid.getCells()[i + 1][j].getBurned ()) {
							grid.getCells()[i + 1][j].setOnFire(true);
							
						}
					} else if (i < grid.getHeight() - 1 && j == 0) {
						if (RandomProbability() >= pP && !grid.getCells()[i + 1][j].getBurned ()) {
							grid.getCells()[i + 1][j].setOnFire(true);
							
						}  if (RandomProbability() >= pP && !grid.getCells()[i - 1][j].getBurned ()) {
							grid.getCells()[i - 1][j].setOnFire(true);
							
						}  if (RandomProbability() >= pP && !grid.getCells()[i][j + 1].getBurned ()) {
							grid.getCells()[i][j + 1].setOnFire(true);
							
						}
					} else if (i == grid.getHeight() - 1 && j < grid.getWidth() - 1) {
						if (RandomProbability() >= pP && !grid.getCells()[i][j - 1].getBurned ()) {
							grid.getCells()[i][j - 1].setOnFire(true);
							
						}  if (RandomProbability() >= pP && !grid.getCells()[i][j + 1].getBurned ()) {
							grid.getCells()[i][j + 1].setOnFire(true);
							
						}  if (RandomProbability() >= pP && !grid.getCells()[i - 1][j].getBurned ()) {
							grid.getCells()[i - 1][j].setOnFire(true);
							
						}
					} else if (i < grid.getHeight() - 1 && j == grid.getWidth() - 1) {
						if (RandomProbability() >= pP && !grid.getCells()[i + 1][j].getBurned ()) {
							grid.getCells()[i + 1][j].setOnFire(true);
							
						}  if (RandomProbability() >= pP && !grid.getCells()[i - 1][j].getBurned ()) {
							grid.getCells()[i - 1][j].setOnFire(true);
							
						}  if (RandomProbability() >= pP && !grid.getCells()[i][j - 1].getBurned ()) {
							grid.getCells()[i][j - 1].setOnFire(true);
							
						}
					}
				}
			}
			etatFireGrid.add(currentCell);
		}
		return etatFireGrid;
	}
	public double RandomProbability() {
		int minProba = 0;
		int maxProba = 1;

		return Math.random() * (maxProba - minProba) + minProba;
	}
	
	public void EtatFireCells( List<Cell> tatFireGrid) {
		Grid g = new Grid();
		for (int i = 0; i < grid.getHeight(); i++) {
			for (int j = 0; j < grid.getWidth(); j++) {
				grid.getCells()[i][j] = new Cell(i, j);
			}
		}
		for (Cell fireCell : update(g.getpP())) {
			
			grid.getCells()[fireCell.getCordX()][fireCell.getCordY()].setOnFire(fireCell.getOnFire());
			grid.getCells()[fireCell.getCordX()][fireCell.getCordY()].setOnFire(fireCell.getBurned()); 
		}
	}
	
	public boolean hasFire() {
		for (int i = 0; i < grid.getHeight(); i++) {
			for (int j = 0; j < grid.getWidth(); j++) {
				if (grid.getCells()[i][j].getOnFire ()) {
					return true;
				}

			}
		}
		return false;
	}
	
	public Grid start (double pP) {
		while(hasFire()) {
			update(pP);
			int steps = grid.getSteps();
			grid.setSteps(++steps);
			System.out.println(grid.getSteps());
		}
		return grid;
	}

	public int getBurnedCellsCount() {
		int burnedCellsCount = 0;
		Cell[][] cells = grid.getCells();
		 for (int i = 0; i < grid.getHeight(); i++) {
	            for (int j = 0; j < grid.getWidth(); j++) {
	                if (cells[i][j].getBurned()) {
	                    burnedCellsCount++;
	                }
	            }
	        }
		 return burnedCellsCount;
	}

}
