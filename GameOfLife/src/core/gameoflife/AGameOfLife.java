package core.gameoflife;

import core.entities.Cell;
import core.entities.CellGrid;

public abstract class AGameOfLife {

	private int m;
	private int n;
	private CellGrid cells;

	public AGameOfLife(int m, int n, CellGrid cells) {

		this.m=m;
		this.n=n;
		this.cells=cells;
	}
	
	public AGameOfLife(int m, int n) {

		this(m,n,new CellGrid(m,n));
	}
	 

	public CellGrid getCells() {
		return cells;
	}


	public boolean isAlive(int i, int j) {
		return this.cells.isAlive(i, j);
	}
	
	public void bornCell(int i, int j) {
		this.cells.bornCell(i, j);
	}
	
	public void killCell(int i, int j) {
		this.cells.killCell(i, j);
	}

	private int countNeighboors(int i, int j) {
		int count=0;

		for(int m=0; m<3; m++) {
			for(int n=0; n<3; n++) {

				if(cells.isAlive(i+m-1, j+n-1)) count++;
			}
		}
		if(cells.isAlive(i, j)) count--;

		return count;
	}

	private void computeNeighboors() {
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				cells.setNeighboor(i, j,countNeighboors(i,j));
			}
		}
	}

	public void nextStep() {

		computeNeighboors();
		
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {

				rules(cells.getCell(i,j));
			}
		}
	}
	
	protected abstract void rules(Cell cell);
	
	public void reset() {
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				cells.killCell(i, j);
			}
		}
	}
	
	public void importPattern(int i, int j, String[] figure) {

		for(int k=0; k<figure.length;k++) {
			for(int l=0; l<figure[k].length();l++) {
				if(figure[k].charAt(l)=='#') {
					bornCell(k+i,l+j);
				}
			}
		}
	}
	
	@Override
	public String toString() {

		String grid="";

		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(!cells.isAlive(i,j)) grid+=".";
				else grid+="#";
				grid+=" ";
			}
			grid+="\n";
		}
		return grid;
	}
}
