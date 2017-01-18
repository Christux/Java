package core.gameoflife;

import core.entities.Cell;
import core.entities.CellGrid;

public class GameOfLifeClassic extends AGameOfLife implements IGameOfLife{

	public GameOfLifeClassic(int m, int n) {
		super(m, n);
	}
	
	public GameOfLifeClassic(int m, int n, CellGrid cells) {
		super(m, n,cells);
	}
	
	@Override
	protected void rules(Cell cell) {
		
		if (!cell.isAlive() && cell.getNeighboor()==3) {
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
