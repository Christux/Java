package core.gameoflife;

import core.entities.Cell;
import core.entities.CellGrid;
import core.entities.NeighboorGrid;

public class HighLife extends AGameOfLife implements IGameOfLife{

	public HighLife(int m, int n) {
		super(m, n);
	}
	
	public HighLife(int m, int n, CellGrid cells, NeighboorGrid neighboors) {
		super(m, n,cells,neighboors);
	}

	@Override
	protected void rules(Cell cell, int nNeighboors) {
		
		if (!cell.isAlive() && (nNeighboors==3 || nNeighboors==6) ) {
			cell.born();
		}
		else {

			if (cell.isAlive() && (nNeighboors==2 || nNeighboors==3)) {
				cell.born();
			}
			else {
				cell.kill();
			}
		}

	}

}
