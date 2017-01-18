package core.entities;

public class CellGrid {
	
	private int m;
	private int n;
	private Cell[] cellGrid;

	public CellGrid(int m, int n) {
		this.m=m;
		this.n=n;
		this.cellGrid=new Cell[m*n];
		for(int i=0; i<m*n; i++) cellGrid[i]=new Cell();
	}
	
	public void killCell(int i, int j) {
		cellGrid[i*n+j].kill();
	}
	
	public void bornCell(int i, int j) {
		cellGrid[i*n+j].born();
	}
	
	public Cell getCell(int i, int j) {
		return cellGrid[i*n+j];
	}
	
	public boolean isAlive(int i, int j) {
		
		if(i<0 || j<0 || i>=m || j>=n) return false;
		return cellGrid[i*n+j].isAlive();
	}
	
	public void setNeighboor(int i, int j, int value) {
		cellGrid[i*n+j].setNeighboor(value);
	}

	public int getNeighboor(int i, int j) {
		return cellGrid[i*n+j].getNeighboor();
	}
}
