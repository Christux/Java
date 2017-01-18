package core.gameoflife;

import core.entities.Cell;
import core.entities.CellGrid;
import core.entities.NeighboorGrid;

public class DayAndNight extends AGameOfLife implements IGameOfLife {

	public DayAndNight(int m, int n) {
		super(m, n);
	}
	
	public DayAndNight(int m, int n, CellGrid cells, NeighboorGrid neighboors) {
		super(m, n,cells,neighboors);
	}

	@Override
	protected void rules(Cell cell, int nNeighboors) {
		
		if (!cell.isAlive() && (nNeighboors==3 || nNeighboors==6 || nNeighboors==7 || nNeighboors==8)) {
			cell.born();
		}
		else {

			if (cell.isAlive() && (nNeighboors==3 || nNeighboors==4 || nNeighboors==6 || nNeighboors==7 || nNeighboors==8)) {
				cell.born();
			}
			else {
				cell.kill();
			}
		}

	}

}
