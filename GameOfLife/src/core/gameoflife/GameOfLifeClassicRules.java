package core.gameoflife;

import core.entities.Cell;

public class GameOfLifeClassicRules extends AGameOfLife implements IGameOfLife{

	public GameOfLifeClassicRules(int m, int n) {
		super(m, n);
	}
	
	@Override
	protected void rules(Cell cell, int nNeighboors) {
		
		if (!cell.isAlive() && nNeighboors==3) {
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
