package core.gameoflife;

import core.entities.Cell;
import core.entities.CellGrid;
import core.entities.NeighboorGrid;

public abstract class AGameOfLife {

	private int m;
	private int n;
	private CellGrid cells;
	private NeighboorGrid neighboors;

	public AGameOfLife(int m, int n) {

		this.m=m;
		this.n=n;
		this.cells=new CellGrid(m,n);
		this.neighboors=new NeighboorGrid(m,n);
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
				neighboors.setNeighboor(i, j,countNeighboors(i,j));
			}
		}
	}

	public void nextStep() {

		computeNeighboors();
		
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {

				rules(cells.getCell(i,j), neighboors.getNeighboor(i,j));
			}
		}
	}
	
	protected abstract void rules(Cell cell, int nNeighboors);
	
	public void reset() {
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				cells.killCell(i, j);
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

	public String printNeighboors() {
		return neighboors.toString();
	}
}
