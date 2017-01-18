package core.gameoflife;

import core.entities.Cell;
import core.entities.CellGrid;

public class HighLife extends AGameOfLife implements IGameOfLife{

	public HighLife(int m, int n) {
		super(m, n);
	}
	
	public HighLife(int m, int n, CellGrid cells) {
		super(m, n,cells);
	}

	@Override
	protected void rules(Cell cell) {
		
		if (!cell.isAlive() && (cell.getNeighboor()==3 || cell.getNeighboor()==6) ) {
			cell.born();
		}
		else {

			if (cell.isAlive() && (cell.getNeighboor()==2 || cell.getNeighboor()==3)) {
				cell.born();
			}
			else {
				cell.kill();
			}
		}

	}

}
