package com.infosys.assignment1.dto;

public class ArrayDTO {
	private int[] Array1;
	private int[] Array2;
	private int[] Array3;
	
	public ArrayDTO(int[] Array1, int[] Array2, int[] Array3) {
		super();
		this.Array1 = Array1;
		this.Array2 = Array2;
		this.Array3 = Array3;
	}

	public int[] getArray1() {
		return Array1;
	}

	public void setArray1(int[] Array1) {
		this.Array1 = Array1;
	}

	public int[] getArray2() {
		return Array2;
	}

	public void setArray2(int[] Array2) {
		this.Array2 = Array2;
	}

	public int[] getArray3() {
		return Array3;
	}

	public void setArray3(int[] Array3) {
		this.Array3 = Array3;
	}
	
	
	
}
