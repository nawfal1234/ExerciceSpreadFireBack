package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Cell {

	@JsonProperty("cordX")
    private int cordX;

    @JsonProperty("cordY")
    private int cordY;

    @JsonProperty("onFire")
    private boolean onFire;

    @JsonProperty("burned")
    private boolean burned;
	
	
    
    
	public Cell() {
		super();
	}


	public Cell(int cordX, int cordY) {
		this.cordX = cordX;
		this.cordY = cordY;
	}


	public Cell(int cordX, int cordY, boolean onFire, boolean burned) {
		this(cordX,cordY);
		this.onFire = onFire;
		this.burned = burned;
	}


	public int getCordX() {
		return cordX;
	}


	public void setCordX(int cordX) {
		this.cordX = cordX;
	}


	public int getCordY() {
		return cordY;
	}


	public void setCordY(int cordY) {
		this.cordY = cordY;
	}


	public boolean getOnFire() {
		return onFire;
	}


	public void setOnFire(boolean onFire) {
		this.onFire = onFire;
	}


	public boolean getBurned() {
		return burned;
	}


	public void setBurned(boolean burned) {
		this.burned = burned;
	}


	
}
