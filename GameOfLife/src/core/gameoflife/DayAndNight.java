package core.gameoflife;

import core.entities.Cell;
import core.entities.CellGrid;

public class DayAndNight extends AGameOfLife implements IGameOfLife {

	public DayAndNight(int m, int n) {
		super(m, n);
	}
	
	public DayAndNight(int m, int n, CellGrid cells) {
		super(m, n,cells);
	}

	@Override
	protected void rules(Cell cell) {
		
		if (!cell.isAlive() && (cell.getNeighboor()==3 || cell.getNeighboor()==6 || cell.getNeighboor()==7 || cell.getNeighboor()==8)) {
			cell.born();
		}
		else {

			if (cell.isAlive() && (cell.getNeighboor()==3 || cell.getNeighboor()==4 || cell.getNeighboor()==6 || cell.getNeighboor()==7 || cell.getNeighboor()==8)) {
				cell.born();
			}
			else {
				cell.kill();
			}
		}

	}

}
